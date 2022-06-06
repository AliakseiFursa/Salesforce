package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import wrappers.DropDown;

@Log4j2
public class LeadPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By LEAD_NAME = By.xpath("//span[text()='Name']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-name");
    public static final By LEAD_STATUS = By.xpath("//span[text()='Lead Status']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-text");
    public static final By LEAD_COMPANY = By.xpath("//span[text()='Company']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-text");
    public static final By LEAD_SOURCE = By.xpath("//span[text()='Lead Source']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-text");
    public static final By LEAD_N_OF_EMPLOYEES = By.xpath("//span[text()='No. of Employees']//ancestor::" +
            "div[contains(@class, 'slds-form-element')]//lightning-formatted-number");
    public static final By EDIT_BUTTON = By.xpath("//button[@name='Edit']");

    public LeadPage(WebDriver driver) {
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
        log.info("Clicking edit lead button");
        driver.findElement(EDIT_BUTTON).click();
    }

    @Step("Deleting lead")
    public void deleteLead() {
        log.info("Deleting lead");
        new DropDown(driver, "", "Lead").selectActionOnEntityPage("Delete");
    }

    @Step("Getting lead name")
    public String getLeadName() {
        return driver.findElement(LEAD_NAME).getText();
    }

    @Step("Getting lead status")
    public String getLeadStatus() {
        return driver.findElement(LEAD_STATUS).getText();
    }

    @Step("Getting lead company")
    public String getLeadCompany() {
        return driver.findElement(LEAD_COMPANY).getText();
    }

    @Step("Getting lead source")
    public String getLeadSource() {
        return driver.findElement(LEAD_SOURCE).getText();
    }

    @Step("Getting number of employees")
    public String getNoOfEmployees() {
        return driver.findElement(LEAD_N_OF_EMPLOYEES).getText();
    }
}
