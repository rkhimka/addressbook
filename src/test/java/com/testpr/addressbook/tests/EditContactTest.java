package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.Contacts;
import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditContactTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigate().groupsPage();
        if (!app.groups().isTestGroupCreated("group 1")) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
        app.navigate().homePage();
        if (app.contacts().all().size() == 0) {
            app.contacts().create(new ContactData()
                    .withFname("Test").withLname("User").withHomePhone("11111").withMobilePhone("22222")
                    .withWorkPhone("33333").withEmail("test@mail.com").withGroup("group 1"), true);
        }
    }

    @Test(enabled = false)
    public void testEditContact() {
        app.navigate().homePage();
        Contacts before = app.contacts().all();
        ContactData contactToModify = before.iterator().next();
        ContactData contact = new ContactData().withId(contactToModify.getId())
                .withFname("Modified").withLname("Name").withEmail("new@mail.com");
        app.contacts().modify(contact, false);
        Contacts after = app.contacts().all();
        assertThat(after.size(), equalTo(before.size()));
        before.remove(contactToModify);
        assertThat(after, equalTo(before.withModified(contactToModify, contact)));
    }
}
