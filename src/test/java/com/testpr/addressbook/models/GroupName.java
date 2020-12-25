package com.testpr.addressbook.models;

public class GroupName {
    private final String groupName;
    private final String headerName;
    private final String comment;

    public GroupName(String groupName, String headerName, String comment) {
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
