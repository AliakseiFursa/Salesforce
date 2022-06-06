package pages;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactsListPage extends BasePage {

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Contacts']");
    public static final By NEW_CONTACT_BUTTON = By.cssSelector("a[title=New]");
    String contactName = "//tbody//a[text()='%s']";

    public ContactsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Opening contacts page")
    public void openPage() {
        log.info("Opening contacts page");
        driver.get(contactsListPageURL);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE);
    }

    @Step("Creating new contact")
    public void createNewContact() {
        log.info("Opening New Contact Modal page");
        driver.findElement(NEW_CONTACT_BUTTON).click();
    }

    @Step("Opening contact")
    public void openContact(Contact contact) {
        driver.findElement(By.xpath(String.format(contactName, contact.getLastName()))).click();
    }

    @Step("Looking if contact is in contacts list")
    public boolean isContactLocatedOnPage(Contact contact) {
        try {
            driver.findElement(By.xpath(String.format("//a[@title='%s']", contact.getSalutation() +
                    contact.getFirstName() + contact.getLastName()))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
