package tests;

import dto.Contact;
import dto.ContactFactory;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

    @Test(description = "Test of creating new contact with all possible information filled in")
    public void newContactShouldBeCreated() {
        loginSteps.login(user, password);
        Contact contact = ContactFactory.getContact("Mr.", "Hello", "", "Other",
                "10/11/1988");
        contactSteps.create(contact);
        contactSteps.validateContactInformation(contact);
    }

    @Test(description = "Negative test on getting an error message when necessary information wasn't filled in")
    public void errorMessageShouldBeDisplayedIfNecessaryInformationIsEmpty() {
        loginSteps.login(user, password);
        Contact contact = ContactFactory.getContact("Mr.", "Hello", "", "Other",
                "10/11/1988");
        contact.setLastName("");
        contactSteps.create(contact);
        contactSteps.validateErrorMessageBeingDisplayed();
    }

    @Test(description = "Test of creating, validating, editing and deleting of contact")
    public void createReadEditDeleteContact() {
        loginSteps.login(user, password);
        Contact contact = ContactFactory.getContact("Mr.", "Hello", "", "Other",
                "10/11/1988");
        contactSteps.create(contact);
        contactSteps.validateContactInformation(contact);
        contact.setTitle("Hello");
        contact.setPhone("125.568.485");
        contactSteps.edit(contact);
        contactSteps.validateContactInformation(contact);
        contactSteps.deleteFromContactPage(contact);
    }
}
