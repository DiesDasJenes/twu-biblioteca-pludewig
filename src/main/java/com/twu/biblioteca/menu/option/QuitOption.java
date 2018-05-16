package com.twu.biblioteca.menu.option;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;

import java.util.ArrayList;
import java.util.List;

public class QuitOption implements Option {

    @Override
    public String getCommandContent() {
        return "Press (Q) to Quit";
    }


    public String getCommand() {
        return "Q";
    }

    public String executeCommand(Library library) {
        System.exit(1);
        return "Cyao"; //TODO Umbauen zu string sagt quit
    }

    @Override
    public String getUserInput() {
        return null;
    }
}
