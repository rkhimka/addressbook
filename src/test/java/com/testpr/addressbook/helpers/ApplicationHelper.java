package com.testpr.addressbook.helpers;

import com.testpr.addressbook.models.GroupName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationHelper {
    WebDriver wd;

    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\JAVA PROJECTS\\addressbook\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openAddressbook();
        login("admin", "secret");
    }

    public void login(String username, String password) {
        wd.findElement(By.xpath(".//input[@name=\"user\"]")).sendKeys(username);
        wd.findElement(By.xpath(".//input[@name=\"pass\"]")).sendKeys(password);
        wd.findElement(By.xpath(".//input[@value=\"Login\"]")).click();
    }

    public void openAddressbook() {
        wd.get("http://localhost/addressbook/");
    }

    public void submitGroupCreation() {
        wd.findElement(By.xpath(".//input[@value=\"Enter information\"]")).click();
    }

    public void setGroupData(GroupName groupName1) {
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

    public void followGroups() {
        wd.findElement(By.xpath(".//a[text()='groups']")).click();
    }

    public void destroy() {
        wd.close();
    }

    public void submitGroupDeletion() {
        wd.findElement(By.xpath(".//input[@value=\"Delete group(s)\"][1]")).click();
    }

    public void selectFirstGroup() {
        wd.findElement(By.xpath(".//input[@type=\"checkbox\"][1]")).click();
    }
}
