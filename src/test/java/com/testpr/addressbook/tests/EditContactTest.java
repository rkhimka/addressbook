package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class EditContactTest extends TestBase {

    @Test(enabled = false)
    public void testEditContact() {
        app.navigate().homePage();
        if (! app.contacts().isContactCreated("Roma", "Test")) {
            app.contacts().createContact(new ContactData("Roma", "Test", "38099-111-22-33",
                    "test@mail.com", "Lviv city", "test group"), true);
        }
        app.navigate().homePage();
        app.contacts().selectContactByName("Roma", "Test");
        app.contacts().initContactEditing();
        app.contacts().setContactData(new ContactData("New", "Name", "38099-999-77-55",
                "new@mail.com", "New city", null), false);
        app.contacts().submitContactEditing();
    }
}
