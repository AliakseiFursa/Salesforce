package pages;

import dto.Contact;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class NewContactModal extends BasePage{

    WebDriver driver;

    public static final By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//button[@name='SaveEdit']");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'forceFormPageError')]//h2");

    public NewContactModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        driver.get("https://tms-d.lightning.force.com/lightning/o/Contact/new?count=2&nooverride=1&useRecordTypeCheck=" +
                "1&navigationLocation=LIST_VIEW&uid=164935824562090156&backgroundContext=" +
                "%2Flightning%2Fo%2FContact%2Flist%3FfilterName%3DRecent");
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(SAVE_BUTTON);
    }

    @Step("Filling contact information")
    public void fillInContactInformation(Contact contact) {
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
