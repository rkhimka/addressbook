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
        //open addressbook
        wd.get("http://localhost/addressbook/group.php");
        //login
        wd.findElement(By.xpath(".//input[@name=\"user\"]")).sendKeys("admin");
        wd.findElement(By.xpath(".//input[@name=\"pass\"]")).sendKeys("secret");
        wd.findElement(By.xpath(".//input[@value=\"Login\"]")).click();
    }

    @Test
    public void addGroup() {
        //click add group btn
        wd.findElement(By.xpath(".//input[@value=\"New group\"][1]")).click();
        //set group name
        wd.findElement(By.xpath(".//input[@name=\"group_name\"]")).clear();
        wd.findElement(By.xpath(".//input[@name=\"group_name\"]")).sendKeys("test group2");
        //add header
        wd.findElement(By.xpath(".//textarea[@name=\"group_header\"]")).clear();
        wd.findElement(By.xpath(".//textarea[@name=\"group_header\"]")).sendKeys("test header2");
        //add comment
        wd.findElement(By.xpath(".//textarea[@name=\"group_footer\"]")).clear();
        wd.findElement(By.xpath(".//textarea[@name=\"group_footer\"]")).sendKeys("test comment2");
        // submit
        wd.findElement(By.xpath(".//input[@value=\"Enter information\"]")).click();
    }

    @AfterMethod
    public void tearDown() {
        wd.close();
    }
}
