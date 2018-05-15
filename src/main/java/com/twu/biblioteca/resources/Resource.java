package com.twu.biblioteca.resources;

public interface Resource {

    String getOriginalTitle();

    String getUserID();

    void setUserID(String userID);

    String getPropertyList(String fieldFormatStr);

}
