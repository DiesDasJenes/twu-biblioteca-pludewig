package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CheckOutResource implements MenuOption {
    ArrayList<String> subMenuOptions;
    CheckOutResource(){
        commandList = new ArrayList<>();
        commandList.add("bB");
        commandList.add("bM");
    }

    @Override
    public String getCommandContent() {
        return "What would you like to (b)orrow: (B)ook or (M)ovie";
    }

    @Override
    public ArrayList<String> getCommand() {
        return commandList;
    }

    @Override
    public SubMenuOption executeCommand(Library library, String input) {
        return subMenuOptions.stream()
                .filter(option -> input.equals(option.getCommand()))
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public void processOption(Library library) {

    }
}
