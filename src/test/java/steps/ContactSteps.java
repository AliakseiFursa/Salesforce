package steps;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactPage;
import pages.ContactsListPage;
import pages.DeleteEntityModal;
import pages.NewContactModal;

import java.time.Duration;

import static org.testng.Assert.*;

@Log4j2
public class ContactSteps {

    ContactsListPage contactsListPage;
    NewContactModal newContactModal;
    ContactPage contactPage;
    DeleteEntityModal deleteEntityModal;
    WebDriverWait wait;

    public ContactSteps(WebDriver driver) {
        contactsListPage = new ContactsListPage(driver);
        newContactModal = new NewContactModal(driver);
        contactPage = new ContactPage(driver);
        deleteEntityModal = new DeleteEntityModal(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Creation of new contact")
    public void create(Contact contact) {
        log.info("Creation of new contact for account '{}'", contact.getAccountName());
        contactsListPage.openPage();
        assertTrue(contactsListPage.isPageOpened(), "Contacts list page wasn't opened");
        contactsListPage.createNewContact();
        assertTrue(newContactModal.isPageOpened(), "Modal of contact creation wasn't opened");
        newContactModal.fillInContactInformation(contact);
        newContactModal.save();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()=' was created.']")));
    }

    @Step("Editing contact")
    public void edit(Contact contact) {
        log.info("Editing contact '{}'", contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName());
        contactPage.clickEditButton();
        newContactModal.editContactInformation(contact);
        newContactModal.save();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()=' was saved.']")));
    }

    @Step("Deleting contact")
    public void deleteFromContactPage(Contact contact) {
        log.info("Deleting contact '{}'", contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName());
        contactPage.deleteContact();
        deleteEntityModal.confirmDeletion();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class, 'toastMessage')]")));
        assertFalse(contactsListPage.isContactLocatedOnPage(contact), "Contact was found");
    }

    @Step("Validating contact information")
    public void validateContactInformation(Contact contact) {
        log.info("Validating contact information");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class, 'toastMessage')]")));
        contactPage.waitForPageLoaded();
        contactPage.isPageOpened();
        String actualContactName = contactPage.getContactName();
        String actualLeadSource = contactPage.getLeadSource();
        String actualPhone = contactPage.getPhone();
        String actualTitle = contactPage.getTitle();
        assertEquals(actualContactName, contact.getSalutation() + " " + contact.getFirstName() + " " + contact.getLastName(),
                "Contact name doesn't match");
        assertEquals(actualLeadSource, contact.getLeadSource(), "Lead source doesn't match");
        assertEquals(actualPhone, contact.getPhone(), "Phone doesn't match");
        assertEquals(actualTitle, contact.getTitle(), "Title doesn't match");
    }

    @Step("Validating error message")
    public void validateErrorMessageBeingDisplayed() {
        log.info("Validating error message");
        assertEquals(newContactModal.getErrorMessage(), "We hit a snag.",
                "Error message doesn't match or wasn't detected");
    }
}
