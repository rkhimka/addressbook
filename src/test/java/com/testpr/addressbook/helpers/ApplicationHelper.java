package com.testpr.addressbook.helpers;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationHelper {
    ChromeDriver wd;
    private SessionHelper session;
    private NavigationHelper navigation;
    private GroupsHelper groupsHelper;

    public SessionHelper getSession() {
        return session;
    }

    public NavigationHelper getNavigation() {
        return navigation;
    }

    public GroupsHelper getGroupsHelper() {
        return groupsHelper;
    }

    public void init() {
        System.setProperty("webdriver.chrome.driver", "D:\\JAVA PROJECTS\\addressbook\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        session = new SessionHelper(wd);
        navigation = new NavigationHelper(wd);
        groupsHelper = new GroupsHelper(wd);
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
