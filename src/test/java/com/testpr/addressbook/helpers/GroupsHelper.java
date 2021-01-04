package com.testpr.addressbook.helpers;

import com.testpr.addressbook.models.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupsHelper extends BaseHelper {

    public GroupsHelper(WebDriver wd) {
        super(wd);
    }

    public void selectGroupByName(String groupName) {
        String locator = String.format(".//input[@title='Select (%s)']", groupName);
        click(By.xpath(locator));
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public List<GroupData> list(){
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.xpath(".//span[@class='group']"));
        for (WebElement e: elements){
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
            GroupData groupdata = new GroupData().withId(id).withName(e.getText());
            groups.add(groupdata);
        }
        return groups;
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

    //CRUD METHODS
    public void create(GroupData groupData) {
        initGroupCreation();
        setGroupData(groupData);
        submitGroupCreation();
    }

    public void modify(int index, GroupData group) {
        selectGroupByIndex(index);
        initGroupEditing();
        setGroupData(group);
        submitGroupEdition();
    }

    public void deleteByIndex(int index) {
        selectGroupByIndex(index);
        submitGroupDeletion();
    }

    public void deleteByName(String name) {
        selectGroupByName(name);
        submitGroupDeletion();
    }

    //CHECK METHODS
    public boolean isTestGroupCreated(String groupName) {
        String locator = String.format(".//input[@title='Select (%s)']", groupName);
        return isElementPresent(By.xpath(locator));
    }
}
