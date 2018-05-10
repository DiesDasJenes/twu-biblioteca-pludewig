package com.twu.biblioteca.support;

public interface Resource {

    String getTitle();

    String getUserID();

    void setUserID(String userID);

    String propertyList(String fieldFormatStr);

    String propertyHeaders(String fieldFormatStr);
}
