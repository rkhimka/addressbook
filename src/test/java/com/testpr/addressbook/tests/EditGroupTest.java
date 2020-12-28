package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditGroupTest extends TestBase {

    @Test
    public void testEditGroup() {
        app.getNavigation().followGroups();
        if (! app.getGroupsHelper().isAnyGroupCreated()) {
            app.getGroupsHelper().createGroup(new GroupData("test group",
                    "test header", "test comment"));
        }
        app.getNavigation().followGroups();
        int countBeforeTest = app.getGroupsHelper().getGroupsCount();
        app.getGroupsHelper().selectGroupByIndex(1);
        app.getGroupsHelper().initGroupEditing();
        app.getGroupsHelper().setGroupData(new GroupData("new group name",
                "new header", "new comment message"));
        app.getGroupsHelper().submitGroupEdition();
        app.getNavigation().followGroups();
        int countAfterTest = app.getGroupsHelper().getGroupsCount();
        Assert.assertEquals(countAfterTest, countBeforeTest);
    }
}
