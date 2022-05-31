package tests;

import dto.Contact;
import dto.ContactFactory;
import org.testng.annotations.Test;
import wrappers.DropDown;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ContactTest extends BaseTest{

    @Test(description = "Test of creating new contact with all possible information filled in")
    public void newContactShouldBeCreated() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Contact contact = ContactFactory.getContact("Mr.", "Happy", "", "Other",
                "10/11/1988");
        contactSteps.create(contact);
        assertTrue(contactPage.isPageOpened(), "Contact page wasn't opened");
        assertEquals(contactPage.getContactName(), contact.getSalutation() + " " + contact.getFirstName() + " " +
                contact.getLastName(), "Contact name doesn't match");
    }

    @Test(description = "Negative test on getting an error message when necessary information wasn't filled in")
    public void errorMessageShouldBeDisplayedIfNecessaryInformationIsEmpty() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        Contact contact = ContactFactory.getContact("Mr.", "Happy", "", "Other",
                "10/11/1988");
        contact.setLastName("");
        contactSteps.create(contact);
        assertEquals(newContactModal.getErrorMessage(), "We hit a snag.",
                "Error message doesn't match or wasn't detected");
    }

    @Test
    public void contactShouldBeDeleted() {
        loginSteps.login(user, password);
        assertTrue(salesNavigationMenuBarPage.isPageOpened(), "Home page wasn't opened");
        contactsListPage.openPage();
        new DropDown(driver, "Jarod Abernathy", "Contact").selectAction("Delete");
    }
}
