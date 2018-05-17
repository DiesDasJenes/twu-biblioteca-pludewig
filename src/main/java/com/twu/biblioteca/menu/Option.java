package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;

public interface Option {
    String getContent();

    String getKey();

    String execute(Library library);

    int getRequiredPermission();
}
