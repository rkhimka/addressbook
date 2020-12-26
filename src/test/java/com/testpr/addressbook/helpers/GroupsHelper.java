package com.testpr.addressbook.helpers;

import com.testpr.addressbook.models.Groups;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroupsHelper {
    private ChromeDriver wd;

    public GroupsHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void submitGroupDeletion() {
        wd.findElement(By.xpath(".//input[@value=\"Delete group(s)\"][1]")).click();
    }

    public void selectFirstGroup() {
        wd.findElement(By.xpath(".//input[@type=\"checkbox\"][1]")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.xpath(".//input[@value=\"Enter information\"]")).click();
    }

    public void setGroupData(Groups groupName1) {
        //set group name
        wd.findElement(By.xpath(".//input[@name=\"group_name\"]")).clear();
        wd.findElement(By.xpath(".//input[@name=\"group_name\"]")).sendKeys(groupName1.getGroupName());
        //add header
        wd.findElement(By.xpath(".//textarea[@name=\"group_header\"]")).clear();
        wd.findElement(By.xpath(".//textarea[@name=\"group_header\"]")).sendKeys(groupName1.getHeaderName());
        //add comment
        wd.findElement(By.xpath(".//textarea[@name=\"group_footer\"]")).clear();
        wd.findElement(By.xpath(".//textarea[@name=\"group_footer\"]")).sendKeys(groupName1.getComment());
    }

    public void initGroupCreation() {
        wd.findElement(By.xpath(".//input[@value=\"New group\"][1]")).click();
    }
}
