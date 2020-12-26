package com.testpr.addressbook.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends BaseHelper{

    public SessionHelper(ChromeDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.xpath(".//input[@name=\"user\"]"), username);
        type(By.xpath(".//input[@name=\"pass\"]"), password);
        click(By.xpath(".//input[@value=\"Login\"]"));
    }
}
