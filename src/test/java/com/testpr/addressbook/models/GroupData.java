package com.testpr.addressbook.models;

import java.util.Objects;

public class GroupData {
    private int id;
    private final String groupName;
    private final String headerName;
    private final String comment;

    public GroupData(String groupName, String headerName, String comment) {
        this.id = 0;
        this.groupName = groupName;
        this.headerName = headerName;
        this.comment = comment;
    }

    public GroupData(int id, String groupName, String headerName, String comment) {
        this.id = id;
        this.groupName = groupName;
        this.headerName = headerName;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getHeaderName() {
        return headerName;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id='" + id + '\'' +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return id == groupData.id &&
                Objects.equals(groupName, groupData.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupName);
    }
}
