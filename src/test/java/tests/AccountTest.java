package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AccountTest extends BaseTest{

    @Test(description = "Test of creating new account with all possible information filled in")
    public void newAccountShouldBeCreated() {
        loginPage.openLoginPage();
        loginPage.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        accountsPage.openAccountsPage();
        accountsPage.createNewAccount();
        newAccountModal.create("TeachMeSkills", "teachmeskills.by", "Analyst", "256789121",
                "256789122", "Father", "Apparel", "5", "100000", "Hello");
        newAccountModal.save();
        assertEquals(accountPage.getPageTitle(), "Account", "Page title doesn't match");
        assertEquals(accountPage.getAccountName(), "TeachMeSkills", "Account name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when account name wasn't filled in")
    public void errorMessageShouldBeDisplayedIfAccountNameIsEmpty() {
        loginPage.openLoginPage();
        loginPage.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        accountsPage.openAccountsPage();
        accountsPage.createNewAccount();
        newAccountModal.create("", "", "Analyst", "",
                "", "", "Apparel", "", "", "");
        newAccountModal.save();
        assertEquals(newAccountModal.getErrorMessage(), "These required fields must be completed: Account Name",
                "Error doesn't match");
    }
}
