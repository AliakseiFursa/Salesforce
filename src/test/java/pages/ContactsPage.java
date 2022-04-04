package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactsPage extends BasePage{

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Contacts']");
    public static final By NEW_CONTACT_BUTTON = By.cssSelector("a[title=New]");

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening contacts page")
    public void openContactsPage() {
        driver.get("https://tms-d.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE));
    }

    @Step("Creating new contact")
    public void createNewContact() {
        driver.findElement(NEW_CONTACT_BUTTON).click();
    }
}
