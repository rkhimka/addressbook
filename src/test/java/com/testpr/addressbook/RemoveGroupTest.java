package com.testpr.addressbook;

import org.testng.annotations.Test;

public class RemoveGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        followGroups();
        selectFirstGroup();
        submitGroupDeletion();

    }
}
