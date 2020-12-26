package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        app.getNavigation().followGroups();
        app.getGroupsHelper().initGroupCreation();
        app.getGroupsHelper().setGroupData(new GroupData("test group", "test header", "test comment"));
        app.getGroupsHelper().submitGroupCreation();
    }
}
