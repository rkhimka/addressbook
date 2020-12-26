package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class EditContactTest extends TestBase {

    @Test
    public void testAddContact() {
        app.getContactsHelper().selectContactByName("Roma", "Test");
        app.getContactsHelper().initContactEditing();
        app.getContactsHelper().setContactData(new ContactData("Roma", "Test", "38099-999-77-55",
                "new@mail.com", "New city", null), false);
        app.getContactsHelper().submitContactEditing();
        app.getNavigation().followHome();
    }
}
