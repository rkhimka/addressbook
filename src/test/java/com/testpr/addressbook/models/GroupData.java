package com.testpr.addressbook.models;

public class GroupData {
    private final String groupName;
    private final String headerName;
    private final String comment;

    public GroupData(String groupName, String headerName, String comment) {
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