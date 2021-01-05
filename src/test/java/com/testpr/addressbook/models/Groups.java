package com.testpr.addressbook.models;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData> {
    protected Set<GroupData> delegate;

    public Groups() {
        this.delegate = new HashSet<>();
    }

    public Groups(Groups groups) {
        this.delegate = new HashSet<>(groups.delegate);
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups withModified(GroupData old, GroupData modified) {
        Groups groups = new Groups(this);
        groups.remove(old);
        groups.add(modified);
        return groups;
    }

    public Groups withDeleted(GroupData group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
