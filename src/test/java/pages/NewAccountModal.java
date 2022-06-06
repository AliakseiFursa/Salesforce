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
public class NewAccountModal extends BasePage {

    public static final By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//button[@title='Save']");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'modal-body')]//div[contains(@class, 'forcePageError')]//li");
    public static final By TITLE = By.xpath("//h2[text()='New Account']");

    public NewAccountModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        log.info("Opening New Account Modal page");
        driver.get(newAccountModalURL);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(SAVE_BUTTON);
    }

    @Step("Filling account information")
    public void fillInAccountInformation(Account account) {
        log.info("Creation of account {}", account);
        new Input(driver, "Account Name", "Account").write(account.getAccountName());
        new Input(driver, "Parent Account", "Account").write(account.getParentAccount());
        new Input(driver, "Phone", "Account").write(account.getPhone());
        new Input(driver, "Fax", "Account").write(account.getFax());
        new Input(driver, "Website", "Account").write(account.getWebsite());
        new DropDown(driver, "Type", "Account").selectValue(account.getType());
        new DropDown(driver, "Industry", "Account").selectValue(account.getIndustry());
        new Input(driver, "Employees", "Account").write(account.getEmployees());
        new Input(driver, "Annual Revenue", "Account").write(account.getAnnualRevenue());
        new TextArea(driver, "Description", "Account").write(account.getDescription());
        new TextArea(driver, "Billing Street", "Account").write(account.getBillingStreet());
        new Input(driver, "Billing City", "Account").write(account.getBillingCity());
        new Input(driver, "Billing Zip/Postal Code", "Account").write(account.getBillingZipCode());
        new Input(driver, "Billing State/Province", "Account").write(account.getBillingState());
        new Input(driver, "Billing Country", "Account").write(account.getBillingCountry());
        new TextArea(driver, "Shipping Street", "Account").write(account.getShippingStreet());
        new Input(driver, "Shipping City", "Account").write(account.getShippingCity());
        new Input(driver, "Shipping Zip/Postal Code", "Account").write(account.getShippingZipCode());
        new Input(driver, "Shipping State/Province", "Account").write(account.getShippingState());
        new Input(driver, "Shipping Country", "Account").write(account.getShippingCountry());
    }

    @Step("Editing account information ")
    public void editAccountInformation(Account account) {
        log.info("Editing of account {}", account);
        new Input(driver, "Account Name", "Account").write(account.getAccountName());
        new Input(driver, "Parent Account", "Account").write(account.getParentAccount());
        new Input(driver, "Phone", "Account").write(account.getPhone());
        new Input(driver, "Fax", "Account").write(account.getFax());
        new Input(driver, "Website", "Account").write(account.getWebsite());
        new DropDown(driver, "Type", "Account").selectValue(account.getType());
        new DropDown(driver, "Industry", "Account").selectValue(account.getIndustry());
        new Input(driver, "Employees", "Account").write(account.getEmployees());
        new Input(driver, "Annual Revenue", "Account").write(account.getAnnualRevenue());
        new TextArea(driver, "Description", "Account").write(account.getDescription());
        new TextArea(driver, "Billing Street", "Account").write(account.getBillingStreet());
        new Input(driver, "Billing City", "Account").write(account.getBillingCity());
        new Input(driver, "Billing Zip/Postal Code", "Account").write(account.getBillingZipCode());
        new Input(driver, "Billing State/Province", "Account").write(account.getBillingState());
        new Input(driver, "Billing Country", "Account").write(account.getBillingCountry());
        new TextArea(driver, "Shipping Street", "Account").write(account.getShippingStreet());
        new Input(driver, "Shipping City", "Account").write(account.getShippingCity());
        new Input(driver, "Shipping Zip/Postal Code", "Account").write(account.getShippingZipCode());
        new Input(driver, "Shipping State/Province", "Account").write(account.getShippingState());
        new Input(driver, "Shipping Country", "Account").write(account.getShippingCountry());
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
