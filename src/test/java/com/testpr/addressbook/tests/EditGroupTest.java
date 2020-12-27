package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class EditGroupTest extends TestBase {

    @Test
    public void testEditGroup() {
        app.getNavigation().followGroups();
        if (! app.getGroupsHelper().isTestGroupCreated("test group")) {
            app.getGroupsHelper().createGroup(new GroupData("test group", "test header", "test comment"));
        }
        app.getNavigation().followGroups();
        app.getGroupsHelper().selectGroupByName("test group");
        app.getGroupsHelper().initGroupEditing();
        app.getGroupsHelper().setGroupData(new GroupData("new group name",
                "new header", "new comment message"));
        app.getGroupsHelper().submitGroupEdition();
    }
}
