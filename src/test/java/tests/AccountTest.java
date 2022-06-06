package tests;

import dto.Account;
import dto.AccountFactory;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest{

    @Test(description = "Test of creating new account with all possible information filled in")
    public void newAccountShouldBeCreated() {
        loginSteps.login(user, password);
        Account account = AccountFactory.getAccount("", "Analyst", "Apparel");
        accountSteps.create(account);
        accountSteps.validateAccountInformation(account);
    }

    @Test(description = "Negative test on getting an error message when account name wasn't filled in")
    public void errorMessageShouldBeDisplayedIfAccountNameIsEmpty() {
        loginSteps.login(user, password);
        Account account = AccountFactory.getAccount("", "Analyst", "Apparel");
        account.setAccountName("");
        accountSteps.create(account);
        accountSteps.validateErrorMessageBeingDisplayed();
    }

    @Test(description = "Test of creating, validating, editing and deleting of account")
    public void createReadEditDeleteAccount() {
        loginSteps.login(user, password);
        Account account = AccountFactory.getAccount("", "Analyst", "Apparel");
        accountSteps.create(account);
        accountSteps.validateAccountInformation(account);
        account.setType("Press");
        account.setIndustry("Banking");
        accountSteps.edit(account);
        accountSteps.validateAccountInformation(account);
        accountSteps.deleteFromAccountPage(account);
    }
}
