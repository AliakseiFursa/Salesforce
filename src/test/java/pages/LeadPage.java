package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LeadPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By LEAD_NAME = By.xpath("//div[contains(@class, 'entityNameTitle')]/..//lightning-formatted-name");
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

    @Step("Getting page title")
    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Getting lead name")
    public String getLeadName() {
        return driver.findElement(LEAD_NAME).getText();
    }

    @Step("Clicking edit button")
    public void clickEditButton() {
        log.info("Clicking edit lead button");
        driver.findElement(EDIT_BUTTON).click();
    }
}
