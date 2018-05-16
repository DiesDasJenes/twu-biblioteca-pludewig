package com.twu.biblioteca.menu.option;

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

    @Override
    public void processOption() {
        executeCommand();
    }


    public void executeCommand() {
        System.exit(1);
    }
}
