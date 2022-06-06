package tests;

import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Positive log in with correct user data")
    public void correctUserShouldBeLoggedIn() {
        loginSteps.login(user, password);
    }

    @Test
    public void passwordShouldBeRequired() {
        loginSteps.login(user, "");
    }
}
