package com.twu.biblioteca.menu.option;

import com.twu.biblioteca.resources.Library;

import java.util.ArrayList;
import java.util.List;

public class QuitOption {

    public String getCommandContent() {
        return "Press (Q) to Quit";
    }


    public ArrayList<String> getCommand() {
        ArrayList<String> commandList;
        commandList = new ArrayList<>();
        commandList.add("Q");
        return commandList;
    }


    public void processOption() {
        executeCommand();
    }


    public void executeCommand() {
        System.exit(1);
    }
}
