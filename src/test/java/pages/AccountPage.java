package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import wrappers.DropDown;

@Log4j2
public class AccountPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By ACCOUNT_NAME = By.xpath("//span[text()='Account Name']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-text");
    public static final By TYPE = By.xpath("//span[text()='Type']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-text");
    public static final By INDUSTRY = By.xpath("//span[text()='Industry']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-text");
    public static final By PHONE = By.xpath("//span[text()='Phone']//ancestor::div[contains(@class, 'slds-form-element')]//a");
    public static final By EMPLOYEES = By.xpath("//span[text()='Employees']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-number");
    public static final By EDIT_BUTTON = By.xpath("//button[@name='Edit']");

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE);
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }

    @Step("Getting page title")
    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Clicking edit button")
    public void clickEditButton() {
        log.info("Clicking edit account button");
        driver.findElement(EDIT_BUTTON).click();
    }

    @Step("Deleting account")
    public void deleteAccount() {
        log.info("Deleting account");
        new DropDown(driver, "", "Account").selectActionOnEntityPage("Delete");
    }

    @Step("Getting account name")
    public String getAccountName() {
        return driver.findElement(ACCOUNT_NAME).getText();
    }

    @Step("Getting type")
    public String getType() {
        return driver.findElement(TYPE).getText();
    }

    @Step("Getting industry")
    public String getIndustry() {
        return driver.findElement(INDUSTRY).getText();
    }

    @Step("Getting phone")
    public String getPhone() {
        return driver.findElement(PHONE).getText();
    }

    @Step("Getting employees")
    public String getEmployees() {
        return driver.findElement(EMPLOYEES).getText();
    }
}
