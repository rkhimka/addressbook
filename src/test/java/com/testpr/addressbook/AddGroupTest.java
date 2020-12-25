package com.testpr.addressbook;

import org.testng.annotations.Test;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        followGroups();
        initGroupCreation();
        setGroupData(new GroupName("test group", "test header", "test comment"));
        submitGroupCreation();
    }
}
