package pages;

import dto.Account;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

@Log4j2
public class NewAccountModal extends BasePage{

    public static final By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//button[@title='Save']"); //By.cssSelector("[title=Save]");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'modal-body')]//div[contains(@class, 'forcePageError')]//li");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        log.info("Opening New Account Modal page");
        driver.get("https://tms-d.lightning.force.com/lightning/o/Account/new?count=1&nooverride=1&useRecordTypeCheck=" +
                "1&navigationLocation=LIST_VIEW&uid=164935814282050681&backgroundContext=" +
                "%2Flightning%2Fo%2FAccount%2Flist%3FfilterName%3DRecent");
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(SAVE_BUTTON);
    }

    @Step("Filling account information")
    public void fillInAccountInformation(Account account) {
        log.info("Creation of account {}", account);
        new Input(driver, "Account Name", "Account").write(account.getAccountName());
        new Input(driver, "Website", "Account").write(account.getWebsite());
        new DropDown(driver, "Type", "Account").select(account.getType());
        new Input(driver, "Phone", "Account").write(account.getPhone());
        new Input(driver, "Fax", "Account").write(account.getFax());
        new Input(driver, "Parent Account", "Account").write(account.getParentAccount());
        new DropDown(driver, "Industry", "Account").select(account.getIndustry());
        new Input(driver, "Employees", "Account").write(account.getEmployees());
        new Input(driver, "Annual Revenue", "Account").write(account.getAnnualRevenue());
        new TextArea(driver, "Description", "Account").write(account.getDescription());
    }

    @Step("Saving new account")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
