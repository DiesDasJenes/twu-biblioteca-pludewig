package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;

import java.util.ArrayList;
import java.util.List;

public class QuitOption implements MenuOption {
    ArrayList<String> commandList;
    public QuitOption(){
        commandList = new ArrayList<>();
        commandList.add("Q");
    }
    @Override
    public String getCommandContent() {
        return "Press (Q) to Quit";
    }

    @Override
    public ArrayList<String> getCommand() {
        return commandList;
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
