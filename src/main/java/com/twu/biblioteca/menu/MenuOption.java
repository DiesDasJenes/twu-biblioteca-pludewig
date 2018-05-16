package com.twu.biblioteca.menu;

import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MenuOption {
    private ArrayList<SubMenuOption> subMenuOptions;
    private String commandContent;

    MenuOption(String content,SubMenuOption... subMenuOptionsList){
        this.subMenuOptions.addAll(Arrays.asList(subMenuOptionsList));
        this.commandContent = content;
    }

    public String getCommandContent() {
        return commandContent;
    }

    public ArrayList<String> getCommand() {
        ArrayList<String> commandList = new ArrayList<>();
        subMenuOptions.forEach(subM -> commandList.add(subM.getCommand()));
        return commandList;
    }

    public SubMenuOption executeCommand(String input) {
        return subMenuOptions.stream()
                .filter(option -> input.equals(option.getCommand()))
                .collect(Collectors.toList())
                .get(0);
    }

    public void processOption() {
        Querist querist = new Querist(System.in,System.out);
        executeCommand(querist.ask(this.getCommandContent()).toString().trim());
    }

}
