package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;

import java.util.ArrayList;
import java.util.List;

public class QuitOption implements MenuOption {

    @Override
    public String getCommandContent() {
        return "Press (Q) to Quit";
    }

    @Override
    public String getCommand() {
        return "Q";
    }

    @Override
    public void processOption(Library library) {
        executeCommand(library,null);
    }

    @Override
    public void executeCommand(Library library, String input) {
        System.exit(1);
    }
}
