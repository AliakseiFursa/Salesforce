package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ContactPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'entityNameTitle')]");
    public static final By CONTACT_NAME = By.xpath("//div[contains(@class, 'entityNameTitle')]/..//span[contains(@class, 'custom-truncate')]");
    public static final By EDIT_BUTTON = By.xpath("//button[@name='Edit']");

    public ContactPage(WebDriver driver) {
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

    @Step("Getting account name")
    public String getContactName() {
        return driver.findElement(CONTACT_NAME).getText();
    }

    @Step("Clicking edit button")
    public void clickEditButton() {
        log.info("Clicking edit contact button");
        driver.findElement(EDIT_BUTTON).click();
    }
}
