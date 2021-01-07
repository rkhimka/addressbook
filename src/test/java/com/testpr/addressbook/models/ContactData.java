package com.testpr.addressbook.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(of = {"id", "firstName", "lastName"})
@EqualsAndHashCode(of = {"id", "firstName", "lastName"})
public class ContactData {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String group;

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFname(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLname(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
