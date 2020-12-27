package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {

    @Test
    public void testRemoveContact() {
        app.getNavigation().followHome();
        if (! app.getContactsHelper().isContactCreated("Roma", "Test")) {
            app.getContactsHelper().createContact(new ContactData("Roma", "Test", "38099-111-22-33",
                    "test@mail.com", "Lviv city", "test group"), true);
        }
        app.getNavigation().followHome();
        app.getContactsHelper().selectContactByName("Roma", "Test");
        app.getContactsHelper().submitContactDeletion();
        app.getContactsHelper().submitDeletionAlert();
    }
}
