package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;

public interface SubMenuOption {
    String getCommandContent();

    void executeCommand(Library library, String input);

    void processOption(Library library);
}
