package com.testpr.addressbook.tests;

import com.testpr.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class EditGroupTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.navigate().groupsPage();
        if (app.groups().list().size() == 0) {
            app.groups().create(new GroupData("group 1",
                    "header", "test comment..."));
        }
    }

    @Test
    public void testEditGroup() {
        app.navigate().groupsPage();
        List<GroupData> before = app.groups().list();
        int index = before.size() - 1;
        GroupData group = new GroupData(before.get(0).getId(), "modified name",
                "modified header", "new comment...");
        app.groups().modify(index, group);
        app.navigate().groupsPage();
        List<GroupData> after = app.groups().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(group);
        //sort two lists with groups
        Comparator<? super GroupData> byID = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }
}
