package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SalesNavigationMenuBarPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginSteps {

    LoginPage loginPage;
    SalesNavigationMenuBarPage salesNavigationMenuBarPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        salesNavigationMenuBarPage = new SalesNavigationMenuBarPage(driver);
    }

    @Step("Log in with: user - '{user}', password - '{password}'")
    public void login(String user, String password) {
        loginPage.openPage();
        assertTrue(loginPage.isPageOpened(), "Login page wasn't opened");
        loginPage.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
    }

    @Step("Validating error message")
    public void validateErrorMessageBeingDisplayed() {
        log.info("Validating error message");
        assertEquals(loginPage.getErrorMessage(), "Please enter your password.", "Error message didn't match");
    }
}
