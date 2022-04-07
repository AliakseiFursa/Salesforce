package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest{

    @Test(description = "Test of creating new account with all possible information filled in")
    public void newAccountShouldBeCreated() {
        loginSteps.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        accountSteps.create(account);
        assertTrue(accountPage.isPageOpened(), "Account page wasn't opened");
        assertEquals(accountPage.getAccountName(), "TeachMeSkills", "Account name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when account name wasn't filled in")
    public void errorMessageShouldBeDisplayedIfAccountNameIsEmpty() {
        loginSteps.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        account.setAccountName("");
        accountSteps.create(account);
        assertEquals(newAccountModal.getErrorMessage(), "These required fields must be completed: Account Name",
                "Error doesn't match or wasn't detected");
    }
}
