package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void followGroups() {
        if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.xpath(".//input[@value='New group']"))) {
            return;
        }
        click(By.xpath(".//a[text()='groups']"));
    }

    public void followHome() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.xpath(".//a[text()='home']"));
    }

    public void followContactCreation() {
        click(By.xpath(".//a[text()='add new']"));
    }
}
