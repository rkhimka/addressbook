package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void followGroups() {
        click(By.xpath(".//a[text()='groups']"));
    }

    public void followHome() {
        click(By.xpath(".//a[text()='home']"));
    }

    public void followContactCreation() {
        click(By.xpath(".//a[text()='add new']"));
    }
}
