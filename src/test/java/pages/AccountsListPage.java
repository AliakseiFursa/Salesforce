package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountsListPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Accounts']");
    public static final By NEW_ACCOUNT_BUTTON = By.cssSelector("a[title=New]");
    String accountName = "//tbody//a[text()='%s']";

    public AccountsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Opening accounts page")
    public void openPage() {
        log.info("Opening accounts page");
        driver.get(accountsListPageURL);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE);
    }

    @Step("Creating new account")
    public void createNewAccount() {
        driver.findElement(NEW_ACCOUNT_BUTTON).click();
    }

    @Step("Opening account")
    public void openAccount(Account account) {
        driver.findElement(By.xpath(String.format(accountName, account.getAccountName()))).click();
    }

    @Step("Looking if account is in accounts list")
    public boolean isAccountLocatedOnPage(Account account) {
        try {
            driver.findElement(By.xpath(String.format("//a[@title='%s']", account.getAccountName()))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
