package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import wrappers.DropDown;

@Log4j2
public class ContactPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By CONTACT_NAME = By.xpath("//span[text()='Name']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-name");
    public static final By LEAD_SOURCE = By.xpath("//span[text()='Lead Source']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-text");
    public static final By PHONE = By.xpath("//span[text()='Phone']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-phone");
    public static final By TITLE = By.xpath("//span[text()='Title']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-text");
    public static final By EDIT_BUTTON = By.xpath("//button[@name='Edit']");

    public ContactPage(WebDriver driver) {
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
        log.info("Clicking edit contact button");
        driver.findElement(EDIT_BUTTON).click();
    }

    @Step("Deleting contact")
    public void deleteContact() {
        log.info("Deleting contact");
        new DropDown(driver, "", "Contact").selectActionOnEntityPage("Delete");
    }

    @Step("Getting account name")
    public String getContactName() {
        return driver.findElement(CONTACT_NAME).getText();
    }

    @Step("Getting lead source")
    public String getLeadSource() {
        return driver.findElement(LEAD_SOURCE).getText();
    }

    @Step("Getting phone")
    public String getPhone() {
        return driver.findElement(PHONE).getText();
    }

    @Step("Getting title")
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }
}
