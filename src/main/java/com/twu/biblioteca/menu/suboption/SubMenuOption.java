package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Library;

public interface SubMenuOption {
    String getCommandContent();

    String getCommand();

    void executeCommand(Library library, String input);

    void processOption(Library library);

}
