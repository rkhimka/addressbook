package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(ChromeDriver wd) {
        super(wd);
    }

    public void followGroups() {
        click(By.xpath(".//a[text()='groups']"));
    }
}
