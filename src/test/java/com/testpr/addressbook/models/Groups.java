package com.testpr.addressbook.models;

public class Groups {
    private final String groupName;
    private final String headerName;
    private final String comment;

    public Groups(String groupName, String headerName, String comment) {
        this.groupName = groupName;
        this.headerName = headerName;
        this.comment = comment;
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
}
