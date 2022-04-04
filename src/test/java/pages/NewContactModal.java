package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class NewContactModal {

    WebDriver driver;

    public static final By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//button[@name='SaveEdit']");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'forceFormPageError')]//h2");

    public NewContactModal(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Filling contact information")
    public void create(String salutation, String firstName, String lastName, String accountName,
                       String phone, String description, String mailingStreet) {
        new DropDown(driver, "Salutation", "Contact").select(salutation);
        new Input(driver, "First Name", "Contact").write(firstName);
        new Input(driver, "Last Name", "Contact").write(lastName);
        new Input(driver, "Account Name", "Contact").writeAndClick(accountName);
        new Input(driver, "Phone", "Contact").write(phone);
        new TextArea(driver, "Description", "Contact").write(description);
        new TextArea(driver, "Mailing Street", "Contact").write(mailingStreet);
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
