package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        app.getNavigation().followGroups();
        List<GroupData> countBeforeTest = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().createGroup(
                new GroupData("test group", "test header", "test comment"));
        app.getNavigation().followGroups();
        List<GroupData> countAfterTest = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(countAfterTest.size(), countBeforeTest.size() + 1);
    }
}
