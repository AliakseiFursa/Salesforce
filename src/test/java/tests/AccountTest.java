package tests;

import dto.Account;
import dto.AccountFactory;
import org.testng.annotations.Test;
import wrappers.DropDown;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest{

    @Test(description = "Test of creating new account with all possible information filled in")
    public void newAccountShouldBeCreated() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Account account = AccountFactory.getAccount("", "Analyst", "Apparel");
        accountSteps.create(account);
        assertTrue(accountPage.isPageOpened(), "Account page wasn't opened");
        assertEquals(accountPage.getAccountName(), account.getAccountName(), "Account name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when account name wasn't filled in")
    public void errorMessageShouldBeDisplayedIfAccountNameIsEmpty() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Account account = AccountFactory.getAccount("", "Analyst", "Apparel");
        account.setAccountName("");
        accountSteps.create(account);
        assertEquals(newAccountModal.getErrorMessage(), "These required fields must be completed: Account Name",
                "Error doesn't match or wasn't detected");
    }

    @Test(description = "Test of creating new account with all possible information filled in")
    public void AccountShouldBeEdited() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Account account = AccountFactory.getAccount("", "Analyst", "Apparel");
        accountSteps.create(account);
        assertTrue(accountPage.isPageOpened(), "Account page wasn't opened");
        assertEquals(accountPage.getAccountName(), account.getAccountName(), "Account name doesn't match");
        accountPage.clickEditButton();
        account.setType("Press");
        account.setIndustry("Banking");
        newAccountModal.editAccountInformation(account);
        newAccountModal.save();
    }

    @Test
    public void accountShouldBeDeleted() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        accountsListPage.openPage();
        new DropDown(driver, "Efren Sporer", "Account").selectAction("Delete");
    }
}
