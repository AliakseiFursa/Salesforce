package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id = "username")
    WebElement userInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "Login")
    WebElement loginButton;
    public static final By ERROR_MESSAGE = By.id("error");

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Opening login page")
    public void openPage() {
        driver.get(baseURL);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(By.id("Login"));
    }

    @Step("Log in by user '{user}' with password '{password}'")
    public void login(String user, String password) {
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
