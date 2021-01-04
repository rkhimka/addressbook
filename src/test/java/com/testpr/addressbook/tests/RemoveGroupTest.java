package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class RemoveGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.navigate().groupsPage();
        if (app.groups().all().size() == 0) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
    }

    @Test
    public void testDeleteGroup() {
        app.navigate().groupsPage();
        Set<GroupData> before = app.groups().all();
        GroupData groupToDelete = before.iterator().next();
        app.groups().delete(groupToDelete);
        app.navigate().groupsPage();
        Set<GroupData> after = app.groups().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(groupToDelete);
        Assert.assertEquals(before, after);
    }
}
