package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.NewAccountModal;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{

    @Test(description = "Positive log in with correct user data")
    public void correctUserShouldBeLoggedIn() {
        loginPage.openLoginPage();
        loginPage.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        assertEquals(salesNavigationMenuPage.getPageTitle(), "Sales", "Log in failed");
    }

    @Test
    public void passwordShouldBeRequired() {
        loginPage.openLoginPage();
        loginPage.login("alex.fursa89-gtaj@force.com", "");
        assertEquals(loginPage.getErrorMessage(), "Please enter your password.", "Error message didn't match");
    }
}
