package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By CONTACT_NAME = By.xpath("//div[contains(@class, 'entityNameTitle')]/..//span[contains(@class, 'custom-truncate')]");

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @Step("Getting page title")
    public String getPageTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    @Step("Getting account name")
    public String getContactName() {
        return driver.findElement(CONTACT_NAME).getText();
    }
}
