package steps;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage;
import pages.AccountsListPage;
import pages.DeleteEntityModal;
import pages.NewAccountModal;

import java.time.Duration;

import static org.testng.Assert.*;

@Log4j2
public class AccountSteps {

    AccountsListPage accountsListPage;
    NewAccountModal newAccountModal;
    AccountPage accountPage;
    DeleteEntityModal deleteEntityModal;
    WebDriverWait wait;

    public AccountSteps(WebDriver driver) {
        accountsListPage = new AccountsListPage(driver);
        newAccountModal = new NewAccountModal(driver);
        accountPage = new AccountPage(driver);
        deleteEntityModal = new DeleteEntityModal(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Creation of new account: '{account.accountName}'")
    public void create(Account account) {
        log.info("Creation of new account '{}'", account.getAccountName());
        accountsListPage.openPage();
        assertTrue(accountsListPage.isPageOpened(), "Accounts list page wasn't opened");
        accountsListPage.createNewAccount();
        assertTrue(newAccountModal.isPageOpened(), "Modal of account creation wasn't opened");
        newAccountModal.fillInAccountInformation(account);
        newAccountModal.save();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()=' was created.']")));
    }

    @Step("Editing account: '{account.accountName}'")
    public void edit(Account account) {
        log.info("Editing account '{}'", account.getAccountName());
        accountPage.clickEditButton();
        newAccountModal.editAccountInformation(account);
        newAccountModal.save();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()=' was saved.']")));
    }

    @Step("Deleting account: '{account.accountName}'")
    public void deleteFromAccountPage(Account account) {
        log.info("Deleting account '{}'", account.getAccountName());
        accountPage.deleteAccount();
        deleteEntityModal.confirmDeletion();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class, 'toastMessage')]")));
        assertFalse(accountsListPage.isAccountLocatedOnPage(account), "Account was found");
    }

    @Step("Validating account information")
    public void validateAccountInformation(Account account) {
        log.info("Validating account '{}' information", account.getAccountName());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class, 'toastMessage')]")));
        accountPage.waitForPageLoaded();
        accountPage.isPageOpened();
        String actualAccountName = accountPage.getAccountName();
        String actualType = accountPage.getType();
        String actualIndustry = accountPage.getIndustry();
        String actualPhone = accountPage.getPhone();
        String actualEmployees = accountPage.getEmployees();
        assertEquals(actualAccountName, account.getAccountName(), "Account name doesn't match");
        assertEquals(actualType, account.getType(), "Type doesn't match");
        assertEquals(actualIndustry, account.getIndustry(), "Industry doesn't match");
        assertEquals(actualPhone, account.getPhone(), "Phone doesn't match");
        assertEquals(actualEmployees, account.getEmployees(), "Number of employees doesn't match");
    }

    @Step("Validating error message")
    public void validateErrorMessageBeingDisplayed() {
        log.info("Validating error message");
        assertEquals(newAccountModal.getErrorMessage(), "These required fields must be completed: Account Name",
                "Error doesn't match or wasn't detected");
    }
}
