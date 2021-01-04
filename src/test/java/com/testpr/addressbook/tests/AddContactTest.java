package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @Test(enabled = false)
    public void testAddContact() {
        app.navigate().groupsPage();
        if (! app.groups().isTestGroupCreated("test group")) {
            app.groups().create(new GroupData("test group", "test header", "test comment"));
        }
        app.navigate().homePage();
        app.contacts().createContact(new ContactData("Roma", "Test", "38099-111-22-33",
                "test@mail.com", "Lviv city", "test group"), true);
    }
}
