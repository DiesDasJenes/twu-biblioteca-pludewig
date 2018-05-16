package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CheckInResource implements MenuOption {
    ArrayList<SubMenuOption> subMenuOptions;
    CheckInResource(){
        subMenuOptions = new ArrayList<>();
        subMenuOptions.add(new CheckInBookOption());
    }
    @Override
    public String getCommandContent() {
        return "What would you like to (r)eturn: (B)ook or (M)ovie?";
    }

    @Override
    public ArrayList<String> getCommand() {
        ArrayList<String> commandList = new ArrayList<>();
        subMenuOptions.forEach(subM -> commandList.add(subM.getCommand()));
        return commandList;
    }

    @Override
    public SubMenuOption executeCommand(String input) {
        return subMenuOptions.stream()
                .filter(option -> input.equals(option.getCommand()))
                .collect(Collectors.toList())
                .get(0);
    }

    @Override
    public void processOption() {
        Querist querist = new Querist(System.in,System.out);
        executeCommand(querist.ask(this.getCommandContent()).toString().trim());
    }
}
