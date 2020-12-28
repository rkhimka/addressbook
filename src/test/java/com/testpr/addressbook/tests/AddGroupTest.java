package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        app.getNavigation().followGroups();
        List<GroupData> before = app.getGroupsHelper().getGroupsList();
        GroupData group = new GroupData("test group", "test header", "test comment");
        app.getGroupsHelper().createGroup(group);
        app.getNavigation().followGroups();
        List<GroupData> after = app.getGroupsHelper().getGroupsList();
        Assert.assertEquals(after.size(), before.size() + 1);
        //set max ID for newly created group
        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }
}
