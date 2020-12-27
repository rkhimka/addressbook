package com.testpr.addressbook.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationHelper {
    WebDriver wd;
    private SessionHelper session;
    private NavigationHelper navigation;
    private GroupsHelper groupsHelper;
    private ContactsHelper contactsHelper;
    private String browser;

    public ApplicationHelper(String browser) {
        this.browser = browser;
    }

    public ContactsHelper getContactsHelper() {
        return contactsHelper;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public GroupsHelper getGroupsHelper() {
        return groupsHelper;
    }

    public void init() {
        //System.setProperty("webdriver.chrome.driver", "D:\\JAVA PROJECTS\\addressbook\\chromedriver.exe");
        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        }
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        session = new SessionHelper(wd);
        navigation = new NavigationHelper(wd);
        groupsHelper = new GroupsHelper(wd);
        contactsHelper = new ContactsHelper(wd);
        openAddressbook();
        session.login("admin", "secret");
    }

    public void destroy() {
        wd.close();
    }

    public void openAddressbook() {
        wd.get("http://localhost/addressbook/");
    }
}
