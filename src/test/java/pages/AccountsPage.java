package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Accounts']");
    public static final By NEW_ACCOUNT_BUTTON = By.cssSelector("a[title=New]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening accounts page")
    public void openAccountsPage() {
        driver.get("https://tms-d.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    @Step("Creating new account")
    public void createNewAccount() {
        driver.findElement(NEW_ACCOUNT_BUTTON).click();
    }
}
