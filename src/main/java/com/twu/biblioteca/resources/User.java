package com.twu.biblioteca.resources;

import java.util.Map;

public interface User {

    String getID();

    void setID(String ID);

    Map<String, Resource> getBorrowedResources();
}
