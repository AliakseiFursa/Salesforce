package tests;

import dto.Contact;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest{

    @Test(description = "Test of creating new contact with all possible information filled in")
    public void newContactShouldBeCreated() {
        loginSteps.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Contact contact = Contact.builder()
                .salutation("Mr.")
                .firstName("Al")
                .lastName("Fur")
                .accountName("TeachMeSkills")
                .phone("2235616")
                .description("Good boy")
                .mailingStreet("Minsk")
                .build();
        contactSteps.create(contact);
        assertTrue(contactPage.isPageOpened(), "Contact page wasn't opened");
        assertEquals(contactPage.getContactName(), "Mr. Al Fur", "Contact name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when necessary information wasn't filled in")
    public void errorMessageShouldBeDisplayedIfNecessaryInformationIsEmpty() {
        loginSteps.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Contact contact = Contact.builder()
                .salutation("Mr.")
                .firstName("Al")
                .lastName("")
                .accountName("TeachMeSkills")
                .phone("2235616")
                .description("Good boy")
                .mailingStreet("Minsk")
                .build();
        contactSteps.create(contact);
        assertEquals(newContactModal.getErrorMessage(), "We hit a snag.",
                "Error message doesn't match or wasn't detected");
    }
}
