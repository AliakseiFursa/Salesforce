package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    String baseURL = "https://tms1.my.salesforce.com/";
    String newAccountModalURL = baseURL + "lightning/o/Account/new?count=1&nooverride=" +
            "1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=164935814282050681&backgroundContext=" +
            "%2Flightning%2Fo%2FAccount%2Flist%3FfilterName%3DRecent";
    String newContactModalURL = baseURL + "lightning/o/Contact/new?count=2&nooverride=" +
            "1&useRecordTypeCheck=1&navigationLocation=LIST_VIEW&uid=164935824562090156&backgroundContext=" +
            "%2Flightning%2Fo%2FContact%2Flist%3FfilterName%3DRecent";
    String newLeadModalURL = baseURL + "lightning/o/Lead/new?count=1&nooverride=1&useRecordTypeCheck=" +
            "1&navigationLocation=LIST_VIEW&uid=165359686534080522&backgroundContext=" +
            "%2Flightning%2Fo%2FLead%2Flist%3FfilterName%3DRecent";
    String accountsListPageURL = baseURL + "lightning/o/Account/list?filterName=Recent";
    String contactsListPageURL = baseURL + "lightning/o/Contact/list?filterName=Recent";
    String leadsListPageURL = baseURL + "lightning/o/Lead/list?filterName=Recent";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public abstract boolean isPageOpened();

    public abstract void openPage();

    boolean waitForElement(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {
            log.error("Cannot find element using locator {}", locator);
            log.error(ex.getLocalizedMessage());
            return false;
        }
        return true;
    }

}
