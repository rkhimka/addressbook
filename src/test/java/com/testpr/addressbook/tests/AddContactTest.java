package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @Test
    public void testAddContact() {
        app.getNavigation().followContactCreation();
        app.getContactsHelper().setContactData(new ContactData("Roma", "Test", "38099-111-22-33",
                "test@mail.com", "Lviv city", "test group"), true);
        app.getContactsHelper().submitContactCreation();
        app.getNavigation().followHome();
    }
}
