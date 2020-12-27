package com.testpr.addressbook.tests;

import org.testng.annotations.Test;

public class RemoveContactTest extends TestBase {

    @Test
    public void testRemoveContact() {
        app.getNavigation().followHome();
        app.getContactsHelper().selectContactByName("Roma", "Test");
        app.getContactsHelper().submitContactDeletion();
        app.getContactsHelper().submitDeletionAlert();
    }
}
