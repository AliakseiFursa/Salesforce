package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test(description = "Positive log in with correct user data")
    public void correctUserShouldBeLoggedIn() {
        loginSteps.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
    }

    @Test
    public void passwordShouldBeRequired() {
        loginSteps.login("alex.fursa89-gtaj@force.com", "");
        assertEquals(loginPage.getErrorMessage(), "Please enter your password.", "Error message didn't match");
    }
}
