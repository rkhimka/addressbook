package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        GroupData group = new GroupData().withName("group 1").withHeader("header").withComment("comment...");
        app.navigate().groupsPage();
        Set<GroupData> before = app.groups().all();
        app.groups().create(group);
        app.navigate().groupsPage();
        Set<GroupData> after = app.groups().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
