package steps;

import dto.Lead;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DeleteEntityModal;
import pages.LeadPage;
import pages.LeadsListPage;
import pages.NewLeadModal;

import java.time.Duration;

import static org.testng.Assert.*;

@Log4j2
public class LeadSteps {

    LeadsListPage leadsListPage;
    NewLeadModal newLeadModal;
    LeadPage leadPage;
    DeleteEntityModal deleteEntityModal;
    WebDriverWait wait;

    public LeadSteps(WebDriver driver) {
        leadsListPage = new LeadsListPage(driver);
        newLeadModal = new NewLeadModal(driver);
        leadPage = new LeadPage(driver);
        deleteEntityModal = new DeleteEntityModal(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Creation of new lead")
    public void create(Lead lead) {
        log.info("Creation of new lead '{}'", lead.getSalutation() + " " + lead.getFirstName() + " " + lead.getLastName());
        leadsListPage.openPage();
        assertTrue(leadsListPage.isPageOpened(), "Leads list page wasn't opened");
        leadsListPage.createNewLead();
        assertTrue(newLeadModal.isPageOpened(), "Modal of lead creation wasn't opened");
        newLeadModal.fillInLeadInformation(lead);
        newLeadModal.save();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()=' was created.']")));
    }

    @Step("Editing lead")
    public void edit(Lead lead) {
        log.info("Editing lead '{}'", lead.getSalutation() + " " + lead.getFirstName() + " " + lead.getLastName());
        leadPage.clickEditButton();
        newLeadModal.editLeadInformation(lead);
        newLeadModal.save();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()=' was saved.']")));
    }

    @Step("Deleting lead")
    public void deleteFromLeadPage(Lead lead) {
        log.info("Deleting lead '{}'", lead.getSalutation() + " " + lead.getFirstName() + " " + lead.getLastName());
        leadPage.deleteLead();
        deleteEntityModal.confirmDeletion();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class, 'toastMessage')]")));
        assertFalse(leadsListPage.isLeadLocatedOnPage(lead), "Lead was found");
    }

    @Step("Validating lead information")
    public void validateLeadInformation(Lead lead) {
        log.info("Validating lead information");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(@class, 'toastMessage')]")));
        leadPage.waitForPageLoaded();
        leadPage.isPageOpened();
        String actualLeadName = leadPage.getLeadName();
        String actualLeadStatus = leadPage.getLeadStatus();
        String actualLeadCompany = leadPage.getLeadCompany();
        String actualLeadSource = leadPage.getLeadSource();
        String actualNoOfEmployees = leadPage.getNoOfEmployees();
        assertEquals(actualLeadName, lead.getSalutation() + " " + lead.getFirstName() + " " + lead.getLastName(),
                "Lead name doesn't match");
        assertEquals(actualLeadStatus, lead.getLeadStatus(), "Lead status doesn't match");
        assertEquals(actualLeadCompany, lead.getCompany(), "Company doesn't match");
        assertEquals(actualLeadSource, lead.getLeadSource(), "Lead source doesn't match");
        assertEquals(actualNoOfEmployees, lead.getNumberOfEmployees(), "Number of employees doesn't match");
    }

    @Step("Validating error message")
    public void validateErrorMessageBeingDisplayed() {
        log.info("Validating error message");
        assertEquals(newLeadModal.getErrorMessage(), "We hit a snag.",
                "Error message doesn't match or wasn't detected");
    }
}
