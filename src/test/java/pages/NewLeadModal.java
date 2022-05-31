package pages;

import dto.Lead;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

@Log4j2
public class NewLeadModal extends BasePage{

    public static final By SAVE_BUTTON = By.xpath("//div[contains(@class, 'modal-body')]//button[@name='SaveEdit']");
    public static final By ERROR_MESSAGE = By.xpath("//div[contains(@class, 'forceFormPageError')]//h2");

    public NewLeadModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openPage() {
        log.info("Opening New Lead Modal page");
        driver.get(newLeadModalURL);
    }

    @Override
    public boolean isPageOpened() {
        return waitForElement(SAVE_BUTTON);
    }

    @Step("Filling lead information")
    public void fillInLeadInformation(Lead lead) {
        log.info("Creation of lead {}", lead);
        new DropDown(driver, "Salutation", "Lead").selectValue(lead.getSalutation());
        new Input(driver, "First Name", "Lead").write(lead.getFirstName());
        new Input(driver, "Last Name", "Lead").write(lead.getLastName());
        new Input(driver, "Company", "Lead").write(lead.getCompany());
        new Input(driver, "Title", "Lead").write(lead.getTitle());
        new DropDown(driver, "Lead Status", "Lead").selectValue(lead.getLeadStatus());
        new Input(driver, "Phone", "Lead").write(lead.getPhone());
        new Input(driver, "Email", "Lead").write(lead.getEmail());
        new DropDown(driver, "Rating", "Lead").selectValue(lead.getRating());
        new TextArea(driver, "Street", "Lead").write(lead.getStreet());
        new Input(driver, "City", "Lead").write(lead.getCity());
        new Input(driver, "Zip/Postal Code", "Lead").write(lead.getZipCode());
        new Input(driver, "State/Province", "Lead").write(lead.getState());
        new Input(driver, "Country", "Lead").write(lead.getCountry());
        new Input(driver, "Website", "Lead").write(lead.getWebsite());
        new Input(driver, "No. of Employees", "Lead").write(lead.getNumberOfEmployees());
        new Input(driver, "Annual Revenue", "Lead").write(lead.getAnnualRevenue());
        new DropDown(driver, "Lead Source", "Lead").selectValue(lead.getLeadSource());
        new DropDown(driver, "Industry", "Lead").selectValue(lead.getIndustry());
        new TextArea(driver, "Description", "Lead").write(lead.getDescription());
    }

    @Step("Saving new lead")
    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Getting error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
