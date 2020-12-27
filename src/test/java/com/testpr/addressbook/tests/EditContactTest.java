package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class EditContactTest extends TestBase {

    @Test
    public void testEditContact() {
        app.getNavigation().followHome();
        if (! app.getContactsHelper().isContactCreated("Roma", "Test")) {
            app.getContactsHelper().createContact(new ContactData("Roma", "Test", "38099-111-22-33",
                    "test@mail.com", "Lviv city", "test group"), true);
        }
        app.getNavigation().followHome();
        app.getContactsHelper().selectContactByName("Roma", "Test");
        app.getContactsHelper().initContactEditing();
        app.getContactsHelper().setContactData(new ContactData("New", "Name", "38099-999-77-55",
                "new@mail.com", "New city", null), false);
        app.getContactsHelper().submitContactEditing();
    }
}
