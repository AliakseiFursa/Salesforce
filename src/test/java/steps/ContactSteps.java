package steps;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.ContactsListPage;
import pages.NewContactModal;

import static org.testng.Assert.assertTrue;

@Log4j2
public class ContactSteps {

    ContactsListPage contactsListPage;
    NewContactModal newContactModal;

    public ContactSteps(WebDriver driver) {
        contactsListPage = new ContactsListPage(driver);
        newContactModal = new NewContactModal(driver);
    }

    @Step("Creation of new contact")
    public void create(Contact contact) {
        log.info("Creation of new contact");
        contactsListPage.openPage();
        assertTrue(contactsListPage.isPageOpened(), "Contacts list page wasn't opened");
        contactsListPage.createNewContact();
        assertTrue(newContactModal.isPageOpened(), "Modal of contact creation wasn't opened");
        newContactModal.fillInContactInformation(contact);
        newContactModal.save();
    }
}
