package com.testpr.addressbook.models;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String mobile;
    private final String email;
    private final String address;
    private final String group;

    public ContactData(String firstName, String lasrName, String mobile, String email, String address, String group) {
        this.firstName = firstName;
        this.lastName = lasrName;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getGroup() {
        return group;
    }
}
