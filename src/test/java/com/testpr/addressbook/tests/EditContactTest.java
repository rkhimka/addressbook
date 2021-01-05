package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class EditContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigate().groupsPage();
        if (! app.groups().isTestGroupCreated("group 1")) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
        app.navigate().homePage();
        if (app.contacts().all().size() == 0) {
            app.contacts().create(new ContactData()
                    .withFname("Test").withLname("User").withEmail("test@mail.com").withGroup("group 1"), true);
        }
    }

    @Test(enabled = false)
    public void testEditContact() {
        app.navigate().homePage();
        Set<ContactData> before = app.contacts().all();
        ContactData contactToModify = before.iterator().next();
        ContactData contact = new ContactData().withId(contactToModify.getId())
                .withFname("Modified").withLname("Name").withEmail("new@mail.com").withGroup("group 1");
        app.contacts().modify(contact, false);
        app.navigate().homePage();
        Set<ContactData> after = app.contacts().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(contactToModify);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
