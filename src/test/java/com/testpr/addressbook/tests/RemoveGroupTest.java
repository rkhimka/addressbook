package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveGroupTest extends TestBase {

    @Test
    public void testDeleteGroup() {
        app.getNavigation().followGroups();
        if (! app.getGroupsHelper().isAnyGroupCreated()) {
            app.getGroupsHelper().createGroup(new GroupData("test group", "test header", "test comment"));
        }
        app.getNavigation().followGroups();
        int countBeforeTest = app.getGroupsHelper().getGroupsCount();
        app.getGroupsHelper().selectGroupByIndex(1);
        app.getGroupsHelper().submitGroupDeletion();
        app.getNavigation().followGroups();
        int countAfterTest = app.getGroupsHelper().getGroupsCount();
        Assert.assertEquals(countAfterTest, countBeforeTest - 1);
    }
}
