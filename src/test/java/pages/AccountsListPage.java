package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsListPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Accounts']");
    public static final By NEW_ACCOUNT_BUTTON = By.cssSelector("a[title=New]");

    public AccountsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Opening accounts page")
    public void openPage() {
        driver.get("https://tms-d.lightning.force.com/lightning/o/Account/list?filterName=Recent");
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE);
    }

    @Step("Creating new account")
    public void createNewAccount() {
        driver.findElement(NEW_ACCOUNT_BUTTON).click();
    }
}
