package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BaseHelper {
    protected WebDriver wd;

    public BaseHelper(WebDriver wd) {
        this.wd = wd;
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected void type(By locator, String value) {
        String existingValue = wd.findElement(locator).getAttribute("value");
        if (!value.equals(existingValue)) {
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(value);
        }
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void acceptAlert() {
        wd.switchTo().alert().accept();
    }

    protected void dismissAlert() {
        wd.switchTo().alert().dismiss();
    }
}
