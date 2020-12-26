package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseHelper {
    protected WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String value) {
        if (value != null) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(value);
        }
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }
}
