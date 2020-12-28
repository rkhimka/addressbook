package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveGroupTest extends TestBase {

    @Test
    public void testDeleteGroup() {
        app.getNavigation().followGroups();
        if (! app.getGroupsHelper().isAnyGroupCreated()) {
            app.getGroupsHelper().createGroup(new GroupData("test group", "test header", "test comment"));
        }
        app.getNavigation().followGroups();
        List<GroupData> countBeforeTest = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().selectGroupByIndex(1);
        app.getGroupsHelper().submitGroupDeletion();
        app.getNavigation().followGroups();
        List<GroupData> countAfterTest = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(countAfterTest.size(), countBeforeTest.size() - 1);
    }
}
