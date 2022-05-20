package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadsListPage extends BasePage{

    public static final By NEW_LEAD_BUTTON = By.cssSelector("a[title=New]");

    public LeadsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public void openPage() {

    }
}
