package com.testpr.addressbook.helpers;

import com.testpr.addressbook.models.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupsHelper extends BaseHelper {

    public GroupsHelper(ChromeDriver wd) {
        super(wd);
    }

    public void submitGroupDeletion() {
        click(By.xpath(".//input[@value=\"Delete group(s)\"][1]"));
    }

    public void selectFirstGroup() {
        click(By.xpath(".//input[@type=\"checkbox\"][1]"));
    }

    public void submitGroupCreation() {
        click(By.xpath(".//input[@value=\"Enter information\"]"));
    }

    public void submitGroupEdition() {
        click(By.xpath(".//input[@value=\"Update\"]"));
    }

    public void setGroupData(GroupData groupData) {
        type(By.xpath(".//input[@name=\"group_name\"]"), groupData.getGroupName());
        type(By.xpath(".//textarea[@name=\"group_header\"]"), groupData.getHeaderName());
        type(By.xpath(".//textarea[@name=\"group_footer\"]"), groupData.getComment());
    }

    public void initGroupCreation() {
        click(By.xpath(".//input[@value=\"New group\"][1]"));
    }

    public void initGroupEditing() {
        click(By.xpath(".//input[@value=\"Edit group\"][1]"));
    }

}
