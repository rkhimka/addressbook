package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.Contacts;
import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Contacts before = app.contacts().all();
        app.contacts().create(contact, true);
        Contacts after = app.contacts().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        assertThat(after, equalTo(before.withAdded(contact)));
    }
}
