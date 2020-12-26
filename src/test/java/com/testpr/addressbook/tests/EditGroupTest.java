package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class EditGroupTest extends TestBase {

    @Test
    public void testEditGroupData() {
        app.getNavigation().followGroups();
        app.getGroupsHelper().selectFirstGroup();
        app.getGroupsHelper().initGroupEditing();
        app.getGroupsHelper().setGroupData(new GroupData("new group name",
                "new header", "new comment message"));
        app.getGroupsHelper().submitGroupEdition();
    }
}
