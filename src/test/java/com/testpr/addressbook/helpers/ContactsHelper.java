package com.testpr.addressbook.helpers;

import com.testpr.addressbook.models.ContactData;
import com.testpr.addressbook.models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ContactsHelper extends BaseHelper {

    public ContactsHelper(WebDriver wd) {
        super(wd);
    }

    public void followContactCreation() {
        click(By.xpath(".//a[text()='add new']"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.id(String.valueOf(id))).click();
    }

    public void setContactData(ContactData contact, boolean isCreation) {
        type(By.name("firstname"), contact.getFirstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("email"), contact.getEmail());
        //verification of 'groups' drop-down visibility while creating/editing contact
        if (isCreation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contact.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactEditing() {
        click(By.xpath(".//img[@title='Edit']"));
    }

    public void submitContactEditing() {
        click(By.xpath(".//input[@value='Update'][1]"));
    }

    public void submitContactCreation() {
        click(By.xpath(".//input[@value='Enter'][1]"));
    }

    public void submitContactDeletion() {
        click(By.xpath(".//input[@value='Delete']"));
    }

    public void submitDeletionAlert() {
        acceptAlert();
    }

    public void returnToGroupsPage() {
        click(By.xpath(".//a[text()='home']"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.xpath(".//tr[@name='entry']"));
        for (WebElement e : elements) {
            int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("id"));
            String fName = wd.findElement(By.xpath("//tr[@name='entry']//input[@id='" +
                    id + "']/ancestor::tr/td[3]")).getText();
            String lName = wd.findElement(By.xpath("//tr[@name='entry']//input[@id='" +
                    id + "']/ancestor::tr/td[2]")).getText();
            ContactData contact = new ContactData().withId(id).withFname(fName).withLname(lName);
            contacts.add(contact);
        }
        return contacts;
    }

    public void create(ContactData contactData, boolean isCreation) {
        followContactCreation();
        setContactData(contactData, isCreation);
        submitContactCreation();
        returnToGroupsPage();
    }

    public void modify(ContactData contact, boolean isCreation) {
        selectContactById(contact.getId());
        initContactEditing();
        setContactData(contact, isCreation);
        submitContactEditing();
        returnToGroupsPage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        submitContactDeletion();
        submitDeletionAlert();
        returnToGroupsPage();
    }

    public boolean isContactCreated(String firstName, String lastName) {
        String locator = String.format(".//input[@title='Select (%s %s)']", firstName, lastName);
        return isElementPresent(By.xpath(locator));
    }
}
