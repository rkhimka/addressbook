package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper {
    private ChromeDriver wd;

    public SessionHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void login(String username, String password) {
        wd.findElement(By.xpath(".//input[@name=\"user\"]")).sendKeys(username);
        wd.findElement(By.xpath(".//input[@name=\"pass\"]")).sendKeys(password);
        wd.findElement(By.xpath(".//input[@value=\"Login\"]")).click();
    }
}
