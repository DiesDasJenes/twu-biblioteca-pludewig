package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;

public interface Option {
    String getCommandContent();

    String getCommand();

    String executeCommand(Library library);

    String getUserInput();
}
