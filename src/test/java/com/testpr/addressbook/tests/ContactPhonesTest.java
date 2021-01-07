package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigate().groupsPage();
        if (!app.groups().isTestGroupCreated("group 1")) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
        app.navigate().homePage();
        if (app.contacts().all().size() == 0) {
            app.contacts().create(new ContactData()
                    .withFname("Test").withLname("User").withHomePhone("1 11")
                    .withWorkPhone("+3(12)").withEmail("test@mail.com").withGroup("group 1"), true);
        }
    }

    @Test
    public void testContactPhones() {
        app.navigate().homePage();
        ContactData contact = app.contacts().all().iterator().next();
        ContactData editFormInfo = app.contacts().editFormInfo(contact);
        assertThat(contact.getAllPhones(), equalTo(mergedPhones(editFormInfo)));
    }

    public String mergedPhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((x) -> !x.equals(""))
                .map(ContactPhonesTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}