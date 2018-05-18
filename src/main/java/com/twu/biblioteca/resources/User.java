package com.twu.biblioteca.resources;

import java.util.Map;

public interface User {

    String getID();

    Map<String, Resource> getBorrowedResources();
}
