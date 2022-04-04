package tests;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContactTest extends BaseTest{

    @Test(description = "Test of creating new contact with all possible information filled in")
    public void newContactShouldBeCreated() {
        loginPage.openLoginPage();
        loginPage.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        contactsPage.openContactsPage();
        contactsPage.createNewContact();
        newContactModal.create( "Mr.", "Al", "Fur", "TeachMeSkills", "2235616", "Good boy", "Minsk");
        newContactModal.save();
        assertEquals(contactPage.getPageTitle(), "Contact", "Page title doesn't match");
        assertEquals(contactPage.getContactName(), "Mr. Al Fur", "Contact name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when necessary information wasn't filled in")
    public void errorMessageShouldBeDisplayedIfNecessaryInformationIsEmpty() {
        loginPage.openLoginPage();
        loginPage.login("alex.fursa89-gtaj@force.com", "FireFox_1989");
        contactsPage.openContactsPage();
        contactsPage.createNewContact();
        newContactModal.save();
        assertEquals(newContactModal.getErrorMessage(), "We hit a snag.", "Error message doesn't match");
    }
}
