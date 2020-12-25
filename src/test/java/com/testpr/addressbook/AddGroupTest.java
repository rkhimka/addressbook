package com.testpr.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddGroupTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\JAVA PROJECTS\\addressbook\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //make full screen browser
        wd.manage().window().maximize();
        openAddressbook();
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.xpath(".//input[@name=\"user\"]")).sendKeys(username);
        wd.findElement(By.xpath(".//input[@name=\"pass\"]")).sendKeys(password);
        wd.findElement(By.xpath(".//input[@value=\"Login\"]")).click();
    }

    private void openAddressbook() {
        wd.get("http://localhost/addressbook/");
    }

    @Test
    public void addGroup() {
        followGroups();
        initGroupCreation();
        setGroupData(new GroupName("test group4", "test header4", "test comment4"));
        submitGroupCreation();
    }

    private void submitGroupCreation() {
        wd.findElement(By.xpath(".//input[@value=\"Enter information\"]")).click();
    }

    private void setGroupData(GroupName groupName1) {
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

    private void initGroupCreation() {
        wd.findElement(By.xpath(".//input[@value=\"New group\"][1]")).click();
    }

    private void followGroups() {
        wd.findElement(By.xpath(".//a[text()='groups']")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.close();
    }
}
