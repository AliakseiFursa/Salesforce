package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    String baseURL = "https://tms-d.my.salesforce.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public abstract boolean isPageOpened();

    public abstract void openPage();

    boolean waitForElement(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

}
