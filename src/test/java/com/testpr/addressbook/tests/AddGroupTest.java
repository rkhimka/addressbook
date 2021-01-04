package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class AddGroupTest extends TestBase {

    @Test
    public void testAddGroup() {
        GroupData group = new GroupData("group 1", "header", "comment...");
        app.navigate().groupsPage();
        List<GroupData> before = app.groups().list();
        app.groups().create(group);
        app.navigate().groupsPage();
        List<GroupData> after = app.groups().list();
        Assert.assertEquals(after.size(), before.size() + 1);
        before.add(group);
        //sort two lists with groups
        Comparator<? super GroupData> byID = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }
}
