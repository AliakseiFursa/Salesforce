package pages;

import dto.Lead;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LeadsListPage extends BasePage {

    public static final By PAGE_TITLE = By.xpath("//div[contains(@class, 'slds-breadcrumb__item')]//span[text()='Leads']");
    public static final By NEW_LEAD_BUTTON = By.cssSelector("a[title=New]");
    String leadName = "//tbody//a[text()='%s']";

    public LeadsListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Opening leads page")
    public void openPage() {
        log.info("Opening leads page");
        driver.get(leadsListPageURL);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(PAGE_TITLE);
    }

    @Step("Creating new lead")
    public void createNewLead() {
        log.info("Opening New Lead Modal page");
        driver.findElement(NEW_LEAD_BUTTON).click();
    }

    @Step("Opening lead")
    public void openLead(Lead lead) {
        driver.findElement(By.xpath(String.format(leadName, lead.getLastName()))).click();
    }

    @Step("Looking if lead is in leads list")
    public boolean isLeadLocatedOnPage(Lead lead) {
        try {
            driver.findElement(By.xpath(String.format("//a[@title='%s']", lead.getSalutation() +
                    lead.getFirstName() + lead.getLastName()))).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
