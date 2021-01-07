package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.Contacts;
import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigate().groupsPage();
        if (!app.groups().isTestGroupCreated("group 1")) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
        app.navigate().homePage();
        if (app.contacts().all().size() == 0) {
            app.contacts().create(new ContactData()
                    .withFname("Test").withLname("User").withEmail("test@mail.com").withGroup("group 1"), true);
        }
    }

    @Test(enabled = false)
    public void testRemoveContact() {
        app.navigate().homePage();
        Contacts before = app.contacts().all();
        ContactData contactToRemove = before.iterator().next();
        app.contacts().delete(contactToRemove);
        Contacts after = app.contacts().all();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.withRemoved(contactToRemove)));
    }
}
