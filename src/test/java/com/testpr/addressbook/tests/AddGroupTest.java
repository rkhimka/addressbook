package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        app.getNavigation().followGroups();
        int countBeforeTest = app.getGroupsHelper().getGroupsCount();
        app.getGroupsHelper().createGroup(
                new GroupData("test group", "test header", "test comment"));
        app.getNavigation().followGroups();
        int countAfterTest = app.getGroupsHelper().getGroupsCount();
        Assert.assertEquals(countAfterTest, countBeforeTest + 1);
    }
}
