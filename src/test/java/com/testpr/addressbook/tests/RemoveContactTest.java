package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {

    @Test(enabled = false)
    public void testRemoveContact() {
        app.navigate().homePage();
        if (! app.contacts().isContactCreated("Roma", "Test")) {
            app.contacts().createContact(new ContactData("Roma", "Test", "38099-111-22-33",
                    "test@mail.com", "Lviv city", "test group"), true);
        }
        app.navigate().homePage();
        app.contacts().selectContactByName("Roma", "Test");
        app.contacts().submitContactDeletion();
        app.contacts().submitDeletionAlert();
    }
}
