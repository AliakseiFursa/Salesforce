package steps;

import dto.Lead;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LeadsListPage;
import pages.NewLeadModal;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LeadSteps {

    LeadsListPage leadsListPage;
    NewLeadModal newLeadModal;

    public LeadSteps(WebDriver driver) {
        leadsListPage = new LeadsListPage(driver);
        newLeadModal = new NewLeadModal(driver);
    }

    @Step("Creation of new lead")
    public void create(Lead lead) {
        log.info("Creation of new lead '{}'", lead.getLastName());
        leadsListPage.openPage();
        assertTrue(leadsListPage.isPageOpened(), "Leads list page wasn't opened");
        leadsListPage.createNewLead();
        assertTrue(newLeadModal.isPageOpened(), "Modal of lead creation wasn't opened");
        newLeadModal.fillInLeadInformation(lead);
        newLeadModal.save();
    }
}
