package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.xpath(".//input[@name=\"user\"]"), username);
        type(By.xpath(".//input[@name=\"pass\"]"), password);
        click(By.xpath(".//input[@value=\"Login\"]"));
    }
}
