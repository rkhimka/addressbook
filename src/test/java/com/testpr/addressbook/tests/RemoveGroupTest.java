package com.testpr.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        app.followGroups();
        app.selectFirstGroup();
        app.submitGroupDeletion();

    }
}
