package com.twu.biblioteca.support;

public interface Resource {

    String getTitle();

    String getUserID();

    void setUserID(String userID);

    String getPropertyList(String fieldFormatStr);

}
