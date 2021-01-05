package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class AddContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigate().groupsPage();
        if (app.groups().all().size() == 0) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
    }

    @Test(enabled = false)
    public void testAddContact() {
        ContactData contact = new ContactData()
                .withFname("Test").withLname("User").withEmail("test@mail.com").withGroup("group 1");
        app.navigate().homePage();
        Set<ContactData> before = app.contacts().all();
        app.contacts().create(contact, true);
        app.navigate().homePage();
        Set<ContactData> after = app.contacts().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
