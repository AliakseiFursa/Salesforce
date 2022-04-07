package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By ACCOUNT_NAME = By.xpath("//div[contains(@class, 'entityNameTitle')]/..//lightning-formatted-text");

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

    @Step("Getting page title")
    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Getting account name")
    public String getAccountName() {
        return driver.findElement(ACCOUNT_NAME).getText();
    }
}
