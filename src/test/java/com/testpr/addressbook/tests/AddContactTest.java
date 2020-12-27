package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase {

    @Test
    public void testAddContact() {
        app.getNavigation().followGroups();
        if (! app.getGroupsHelper().isTestGroupCreated("test group")) {
            app.getGroupsHelper().createGroup(new GroupData("test group", "test header", "test comment"));
        }
        app.getNavigation().followHome();
        app.getContactsHelper().createContact(new ContactData("Roma", "Test", "38099-111-22-33",
                "test@mail.com", "Lviv city", "test group"), true);
    }
}
