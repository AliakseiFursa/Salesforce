package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test(description = "Positive log in with correct user data")
    public void correctUserShouldBeLoggedIn() {
        loginSteps.login(user, password);
    }

    @Test
    public void passwordShouldBeRequired() {
        loginSteps.login(user, "");
    }
}
