package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

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
        Set<GroupData> before = app.groups().all();
        GroupData groupToModify = before.iterator().next();
        GroupData group = new GroupData().withId(groupToModify.getId())
                .withName("modified name").withHeader(" new header").withComment(" new comment...");
        app.groups().modify(group);
        app.navigate().groupsPage();
        Set<GroupData> after = app.groups().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(groupToModify);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}
