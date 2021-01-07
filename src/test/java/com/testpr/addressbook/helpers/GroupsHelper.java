package com.testpr.addressbook.helpers;

import com.testpr.addressbook.models.GroupData;
import com.testpr.addressbook.models.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GroupsHelper extends BaseHelper {
    private Groups cache = null;

    public GroupsHelper(WebDriver wd) {
        super(wd);
    }

    public void selectGroupById(int id) {
        wd.findElement(By.xpath(".//input[@value='" + id + "']")).click();
    }

    public int count() {
        return wd.findElements(By.xpath("//input[@name='selected[]']")).size();
    }

    public Groups all(){
        if (cache != null){
            return new Groups(cache);
        }
        cache = new Groups();
        List<WebElement> elements = wd.findElements(By.xpath(".//span[@class='group']"));
        for (WebElement e: elements){
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            GroupData groupdata = new GroupData().withId(id).withName(e.getText());
            cache.add(groupdata);
        }
        return cache;
    }

    public void initGroupCreation() {
        click(By.xpath(".//input[@value='New group'][1]"));
    }

    public void initGroupEditing() {
        click(By.xpath(".//input[@value='Edit group'][1]"));
    }

    public void setGroupData(GroupData groupData) {
        type(By.xpath(".//input[@name='group_name']"), groupData.getGroupName());
        type(By.xpath(".//textarea[@name='group_header']"), groupData.getHeaderName());
        type(By.xpath(".//textarea[@name='group_footer']"), groupData.getComment());
    }

    public void submitGroupCreation() {
        click(By.xpath(".//input[@value='Enter information']"));
    }

    public void submitGroupEdition() {
        click(By.xpath(".//input[@value='Update']"));
    }

    public void submitGroupDeletion() {
        click(By.xpath(".//input[@value='Delete group(s)'][1]"));
    }

    public void returnToGroupsPage() {
        click(By.xpath(".//a[text()='groups']"));
    }

    //CRUD METHODS
    public void create(GroupData groupData) {
        initGroupCreation();
        setGroupData(groupData);
        submitGroupCreation();
        cache = null;
        returnToGroupsPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupEditing();
        setGroupData(group);
        submitGroupEdition();
        cache = null;
        returnToGroupsPage();
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        submitGroupDeletion();
        cache = null;
        returnToGroupsPage();
    }

    //CHECK METHODS
    public boolean isTestGroupCreated(String groupName) {
        String locator = String.format(".//input[@title='Select (%s)']", groupName);
        return isElementPresent(By.xpath(locator));
    }
}
