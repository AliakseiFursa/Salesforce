package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesNavigationMenuPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-context-bar')]//span[text()='Sales']");

    public SalesNavigationMenuPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting page title")
    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }
}
