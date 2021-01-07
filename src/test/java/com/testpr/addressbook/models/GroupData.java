package com.testpr.addressbook.models;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(of = {"id", "groupName"})
@EqualsAndHashCode(of = {"id", "groupName"})
public class GroupData {
    private int id = Integer.MAX_VALUE;
    private String groupName;
    private String headerName;
    private String comment;

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupData withHeader(String headerName) {
        this.headerName = headerName;
        return this;
    }

    public GroupData withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public int getId() {
        return id;
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
