package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.SalesNavigationMenuBarPage;

import static org.testng.Assert.assertTrue;

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
    }
}
