package com.testpr.addressbook.models;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;


public class Contacts extends ForwardingSet<ContactData> {
    protected Set<ContactData> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<>();
    }

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }


    public Contacts withAdded(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts withModified(ContactData old, ContactData modified) {
        Contacts contacts = new Contacts(this);
        contacts.remove(old);
        contacts.add(modified);
        return contacts;
    }

    public Contacts withRemoved(ContactData contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

}