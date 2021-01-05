package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import com.testpr.addressbook.models.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EditGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigate().groupsPage();
        if (app.groups().all().size() == 0) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
    }

    @Test
    public void testEditGroup() {
        app.navigate().groupsPage();
        Groups before = app.groups().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId())
                .withName("modified name").withHeader(" new header").withComment(" new comment...");
        app.groups().modify(group);
        Groups after = app.groups().all();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.withModified(modifiedGroup, group)));
    }
}
