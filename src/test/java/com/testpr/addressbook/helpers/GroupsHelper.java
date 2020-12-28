package com.testpr.addressbook.helpers;

import com.testpr.addressbook.models.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupsHelper extends BaseHelper {

    public GroupsHelper(WebDriver wd) {
        super(wd);
    }

    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectGroupByName(String groupName) {
        String locator = String.format(".//input[@title='Select (%s)']", groupName);
        click(By.xpath(locator));
    }

    public void setGroupData(GroupData groupData) {
        type(By.xpath(".//input[@name='group_name']"), groupData.getGroupName());
        type(By.xpath(".//textarea[@name='group_header']"), groupData.getHeaderName());
        type(By.xpath(".//textarea[@name='group_footer']"), groupData.getComment());
    }

    //CREATE GROUP METHODS
    public void submitGroupCreation() {
        click(By.xpath(".//input[@value='Enter information']"));
    }

    public void initGroupCreation() {
        click(By.xpath(".//input[@value='New group'][1]"));
    }

    public void createGroup(GroupData groupData) {
        initGroupCreation();
        setGroupData(groupData);
        submitGroupCreation();
    }

    // DELETE GROUP METHODS
    public void submitGroupDeletion() {
        click(By.xpath(".//input[@value='Delete group(s)'][1]"));
    }

    public void deleteGroup(String groupName) {
        selectGroupByName(groupName);
        submitGroupDeletion();
    }

    //EDITING GROUP METHODS
    public void submitGroupEdition() {
        click(By.xpath(".//input[@value='Update']"));
    }

    public void initGroupEditing() {
        click(By.xpath(".//input[@value='Edit group'][1]"));
    }

    //CHECK METHODS
    public boolean isTestGroupCreated(String groupName) {
        String locator = String.format(".//input[@title='Select (%s)']", groupName);
        return isElementPresent(By.xpath(locator));
    }
}
