package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class NewAccountModal {

    WebDriver driver;

    public static final By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//button[@title='Save']"); //By.cssSelector("[title=Save]");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'modal-body')]//div[contains(@class, 'forcePageError')]//li");

    public NewAccountModal(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Filling account information")
    public void create(String accountName, String website, String type, String phone, String fax, String parentAccount,
                       String industry, String employees, String annualRevenue, String description) {
        new Input(driver, "Account Name", "Account").write(accountName);
        new Input(driver, "Website", "Account").write(website);
        new DropDown(driver, "Type", "Account").select(type);
        new Input(driver, "Phone", "Account").write(phone);
        new Input(driver, "Fax", "Account").write(fax);
        new Input(driver, "Parent Account", "Account").write(parentAccount);
        new DropDown(driver, "Industry", "Account").select(industry);
        new Input(driver, "Employees", "Account").write(employees);
        new Input(driver, "Annual Revenue", "Account").write(annualRevenue);
        new TextArea(driver, "Description", "Account").write(description);
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
