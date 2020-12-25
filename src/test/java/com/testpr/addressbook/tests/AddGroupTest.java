package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupName;
import org.testng.annotations.Test;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        app.followGroups();
        app.initGroupCreation();
        app.setGroupData(new GroupName("test group", "test header", "test comment"));
        app.submitGroupCreation();
    }
}
