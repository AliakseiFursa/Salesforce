package pages;

import dto.Contact;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

@Log4j2
public class NewContactModal extends BasePage{

    public static final By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//button[@name='SaveEdit']");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'forceFormPageError')]//h2");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        log.info("Opening New Contact Modal page");
        driver.get(newContactModalURL);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(SAVE_BUTTON);
    }

    @Step("Filling contact information")
    public void fillInContactInformation(Contact contact) {
        log.info("Creation of contact {}", contact);
        new DropDown(driver, "Salutation", "Contact").selectValue(contact.getSalutation());
        new Input(driver, "First Name", "Contact").write(contact.getFirstName());
        new Input(driver, "Last Name", "Contact").write(contact.getLastName());
        new Input(driver, "Account Name", "Contact").writeAndClick(contact.getAccountName());
        new Input(driver, "Title", "Contact").write(contact.getTitle());
        new Input(driver, "Phone", "Contact").write(contact.getPhone());
        new Input(driver, "Mobile", "Contact").write(contact.getMobile());
        new Input(driver, "Email", "Contact").write(contact.getEmail());
        new Input(driver, "Reports To", "Contact").write(contact.getReportsTo());
        new TextArea(driver, "Mailing Street", "Contact").write(contact.getMailingStreet());
        new Input(driver, "Mailing City", "Contact").write(contact.getMailingCity());
        new Input(driver, "Mailing Zip/Postal Code", "Contact").write(contact.getMailingZipCode());
        new Input(driver, "Mailing State/Province", "Contact").write(contact.getMailingState());
        new Input(driver, "Mailing Country", "Contact").write(contact.getMailingCountry());
        new TextArea(driver, "Other Street", "Contact").write(contact.getOtherStreet());
        new Input(driver, "Other City", "Contact").write(contact.getOtherCity());
        new Input(driver, "Other Zip/Postal Code", "Contact").write(contact.getOtherZipCode());
        new Input(driver, "Other State/Province", "Contact").write(contact.getOtherState());
        new Input(driver, "Other Country", "Contact").write(contact.getOtherCountry());
        new Input(driver, "Fax", "Contact").write(contact.getFax());
        new Input(driver, "Home Phone", "Contact").write(contact.getHomePhone());
        new Input(driver, "Other Phone", "Contact").write(contact.getOtherPhone());
        new Input(driver, "Asst. Phone", "Contact").write(contact.getAsstPhone());
        new Input(driver, "Assistant", "Contact").write(contact.getAssistant());
        new Input(driver, "Department", "Contact").write(contact.getDepartment());
        new DropDown(driver, "Lead Source", "Contact").selectValue(contact.getLeadSource());
        new Input(driver, "Birthdate", "Contact").write(contact.getBirthdate());
        new TextArea(driver, "Description", "Contact").write(contact.getDescription());
    }

    @Step("Saving new account")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
