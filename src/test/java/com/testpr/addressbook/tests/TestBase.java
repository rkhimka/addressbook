package com.testpr.addressbook.tests;

import com.testpr.addressbook.helpers.ApplicationHelper;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationHelper app = new ApplicationHelper(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.destroy();
    }

}
