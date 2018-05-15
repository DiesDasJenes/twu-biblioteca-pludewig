package com.twu.biblioteca.menu;

import com.twu.biblioteca.support.Library;

public interface MenuOption {

    String getCommandContent();

    String getCommand();

    void executeCommand(Library library,String input);

    void processOption(Library library);

}
