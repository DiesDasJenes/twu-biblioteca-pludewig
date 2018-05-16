package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.option.OptionWithSubOption;
import com.twu.biblioteca.menu.suboption.SubMenuOption;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Menu {

    private ArrayList<OptionWithSubOption> optionWithSubOptions;
    private Library library;
    public Menu(ArrayList<OptionWithSubOption> optionWithSubOptions, Library Library) {
        this.optionWithSubOptions = optionWithSubOptions;
        this.library = Library;
    }

    public void executeMenu() {
        printOptions();
        executeOption(askForOption());
    }

    private SubMenuOption askForOption() {
        Querist Querist = new Querist(System.in, System.out);
        String answer = Querist.ask("Choose an option through typing and combining in the Letter within the brackets from left to right.").toString().trim();
        if (isValidOption(answer)) {
            return optionWithSubOptions.stream().filter(MenuOption -> MenuOption.getSubMenuCommands().contains(answer)).collect(Collectors.toList()).get(0).getSubMenu(answer);
        } else {
            System.out.println("Select a valid option!");
            printOptions();
            return askForOption();
        }

    }

    private void executeOption(SubMenuOption Option){
        Option.processOption(library);
    }

    private void printOptions() {
        optionWithSubOptions.forEach(option -> System.out.println(option.getCommandContent()));
    }

    private boolean isValidOption(String userInput) {
        return optionWithSubOptions.stream().anyMatch(MenuOption -> MenuOption.getSubMenuCommands().stream().anyMatch(input -> input.equals(userInput)));
    }
}

