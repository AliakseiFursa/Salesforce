package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    public static final By USER_INPUT = By.id("username");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("Login");
    public static final By ERROR_MESSAGE = By.id("error");

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public void openLoginPage() {
        driver.get(baseURL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Step("Log in by user '{user}' with password '{password}'")
    public void login(String user, String password) {
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
