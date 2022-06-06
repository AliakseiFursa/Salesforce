package tests;

import dto.Lead;
import dto.LeadFactory;
import org.testng.annotations.Test;

public class LeadTest extends BaseTest {

    @Test(description = "Test of creating new lead with all possible information filled in")
    public void newLeadShouldBeCreated() {
        loginSteps.login(user, password);
        Lead lead = LeadFactory.getLead("Mr.", "Working", "Warm", "Other", "Apparel");
        leadSteps.create(lead);
        leadSteps.validateLeadInformation(lead);
    }

    @Test(description = "Negative test on getting an error message when necessary information wasn't filled in")
    public void errorMessageShouldBeDisplayedIfNecessaryInformationIsEmpty() {
        loginSteps.login(user, password);
        Lead lead = LeadFactory.getLead("Mr.", "New", "Warm", "Other", "Apparel");
        lead.setLastName("");
        leadSteps.create(lead);
        leadSteps.validateErrorMessageBeingDisplayed();
    }

    @Test(description = "Test of creating, validating, editing and deleting of lead")
    public void createReadEditDeleteLead() {
        loginSteps.login(user, password);
        Lead lead = LeadFactory.getLead("Mr.", "New", "Warm", "Other", "Apparel");
        leadSteps.create(lead);
        leadSteps.validateLeadInformation(lead);
        lead.setNumberOfEmployees("5");
        lead.setCompany("AQA");
        leadSteps.edit(lead);
        leadSteps.validateLeadInformation(lead);
        leadSteps.deleteFromLeadPage(lead);
    }
}
