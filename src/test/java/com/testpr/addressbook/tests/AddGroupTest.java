package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import com.testpr.addressbook.models.Groups;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        GroupData group = new GroupData().withName("group 1").withHeader("header").withComment("comment...");
        app.navigate().groupsPage();
        Groups before = app.groups().all();
        app.groups().create(group);
        Groups after = app.groups().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        assertThat(after, equalTo(before.withAdded(group)));
    }
}
