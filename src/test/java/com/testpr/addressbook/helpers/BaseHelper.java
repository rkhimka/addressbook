package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseHelper {
    protected ChromeDriver wd;

    public BaseHelper(ChromeDriver wd) {
        this.wd = wd;
    }

    protected void type(By locator, String value) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(value);
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }
}
