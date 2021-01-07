package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import com.testpr.addressbook.models.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RemoveGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigate().groupsPage();
        if (app.groups().all().size() == 0) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
    }

    @Test
    public void testDeleteGroup() {
        app.navigate().groupsPage();
        Groups before = app.groups().all();
        GroupData groupToDelete = before.iterator().next();
        app.groups().delete(groupToDelete);
        assertThat(app.groups().count(), equalTo(before.size() - 1));
        Groups after = app.groups().all();
        assertThat(after, equalTo(before.withDeleted(groupToDelete)));
    }
}
