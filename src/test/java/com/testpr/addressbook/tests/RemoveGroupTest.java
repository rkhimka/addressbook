package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.navigate().groupsPage();
        if (app.groups().list().size() == 0) {
            app.groups().create(new GroupData().withName("group 1").withHeader("header").withComment("comment..."));
        }
    }

    @Test
    public void testDeleteGroup() {
        app.navigate().groupsPage();
        List<GroupData> before = app.groups().list();
        int index = before.size() - 1;
        app.groups().deleteByIndex(index);
        app.navigate().groupsPage();
        List<GroupData> after = app.groups().list();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
