package com.testpr.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        app.getNavigation().followGroups();
        app.getGroupsHelper().selectFirstGroup();
        app.getGroupsHelper().submitGroupDeletion();

    }
}
