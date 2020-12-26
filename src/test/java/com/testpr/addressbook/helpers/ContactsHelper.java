package com.testpr.addressbook.helpers;

import com.testpr.addressbook.models.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactsHelper extends BaseHelper {

    public ContactsHelper(WebDriver wd) {
        super(wd);
    }

    public void setContactData(ContactData contactData, boolean isCreation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        //verification of 'groups' drop-down visibility on create/edit contact process
        if (isCreation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void selectContactByName(String firstName, String lastName) {
        String locator = String.format(".//input[@title=\"Select (%s %s)\"]", firstName, lastName);
        click(By.xpath(locator));
    }

    //CREATION METHODS
    public void submitContactCreation() {
        click(By.xpath(".//input[@value='Enter'][1]"));
    }

    //EDITING METHODS
    public void initContactEditing() {
        click(By.xpath(".//img[@title='Edit']"));
    }

    public void submitContactEditing() {
        click(By.xpath(".//input[@value='Update'][1]"));
    }

    //DELETION METHODS
    public void submitContactDeletion() {
        click(By.xpath(".//input[@value='Delete']"));
    }

    public void submitDeletionAlert() {
        acceptAlert();
    }
}
