package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalesNavigationMenuBarPage extends BasePage {

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-context-bar')]//span[text()='Sales']");

    public SalesNavigationMenuBarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE);
    }

    @Step("Getting page title")
    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }
}
