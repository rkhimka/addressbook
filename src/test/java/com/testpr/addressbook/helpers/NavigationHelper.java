package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper {
    private ChromeDriver wd;

    public NavigationHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    public void followGroups() {
        wd.findElement(By.xpath(".//a[text()='groups']")).click();
    }
}
