package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class EditGroupTest extends TestBase {

    @Test
    public void testEditGroup() {
        app.getNavigation().followGroups();
        if (! app.getGroupsHelper().isAnyGroupCreated()) {
            app.getGroupsHelper().createGroup(new GroupData("test group",
                    "test header", "test comment"));
        }
        app.getNavigation().followGroups();
        List<GroupData> before = app.getGroupsHelper().getGroupsList();
        app.getGroupsHelper().selectGroupByIndex(1);
        app.getGroupsHelper().initGroupEditing();
        GroupData group = new GroupData(before.get(0).getId(), "new group name",
                "new header", "new comment message");
        app.getGroupsHelper().setGroupData(group);
        app.getGroupsHelper().submitGroupEdition();
        app.getNavigation().followGroups();
        List<GroupData> after = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
}
