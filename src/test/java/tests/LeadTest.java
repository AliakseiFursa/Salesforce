package tests;

import dto.Lead;
import dto.LeadFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LeadTest extends BaseTest{

    @Test(description = "Test of creating new lead with all possible information filled in")
    public void newLeadShouldBeCreated() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Lead lead = LeadFactory.getLead("Mr.", "Working", "Warm", "Other", "Apparel");
        leadSteps.create(lead);
        assertTrue(leadPage.isPageOpened(), "Lead page wasn't opened");
        assertEquals(leadPage.getLeadName(), lead.getSalutation() + " " + lead.getFirstName() + " " +
                lead.getLastName(), "Lead name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when necessary information wasn't filled in")
    public void errorMessageShouldBeDisplayedIfNecessaryInformationIsEmpty() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Lead lead = LeadFactory.getLead("Mr.", "New", "Warm", "Other", "Apparel");
        lead.setLastName("");
        leadSteps.create(lead);
        assertEquals(newLeadModal.getErrorMessage(), "We hit a snag.",
                "Error message doesn't match or wasn't detected");
    }
}
