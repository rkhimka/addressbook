package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class RemoveGroupTest extends TestBase {

    @Test
    public void testDeleteGroup() {
        app.getNavigation().followGroups();
        if (! app.getGroupsHelper().isTestGroupCreated("test group")) {
            app.getGroupsHelper().createGroup(new GroupData("test group", "test header", "test comment"));
        }
        app.getNavigation().followGroups();
        app.getGroupsHelper().selectGroupByName("test group");
        app.getGroupsHelper().submitGroupDeletion();
    }
}
