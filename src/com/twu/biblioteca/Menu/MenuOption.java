package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Library;

public interface MenuOption {

    String getCommandContent();

    String getCommand();

    void executeCommand(Library library);

}
