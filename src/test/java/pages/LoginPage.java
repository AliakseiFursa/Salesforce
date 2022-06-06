package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class LoginPage extends BasePage {

    public static final By ERROR_MESSAGE = By.id("error");
    @FindBy(id = "username")
    WebElement userInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "Login")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Opening login page")
    public void openPage() {
        log.info("Opening login page");
        driver.get(baseURL);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(By.id("Login"));
    }

    @Step("Log in by user '{user}' with password '{password}'")
    public void login(String user, String password) {
        log.info("Log in by user '{}' with password '{}'", user, password);
        userInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
