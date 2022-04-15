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
        driver.get(NewContactModalURL);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(SAVE_BUTTON);
    }

    @Step("Filling contact information")
    public void fillInContactInformation(Contact contact) {
        log.info("Creation of contact {}", contact);
        new DropDown(driver, "Salutation", "Contact").select(contact.getSalutation());
        new Input(driver, "First Name", "Contact").write(contact.getFirstName());
        new Input(driver, "Last Name", "Contact").write(contact.getLastName());
        new Input(driver, "Account Name", "Contact").writeAndClick(contact.getAccountName());
        new Input(driver, "Phone", "Contact").write(contact.getPhone());
        new TextArea(driver, "Description", "Contact").write(contact.getDescription());
        new TextArea(driver, "Mailing Street", "Contact").write(contact.getMailingStreet());
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
