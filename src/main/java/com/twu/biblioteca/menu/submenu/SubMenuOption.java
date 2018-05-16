package com.twu.biblioteca.menu.submenu;

import com.twu.biblioteca.resources.Library;

public interface SubMenuOption {
    String getCommandContent();

    String getCommand();

    void executeCommand(Library library, String input);

    void processOption(Library library);
}
