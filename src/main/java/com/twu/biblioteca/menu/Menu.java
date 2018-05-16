package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.option.Option;
import com.twu.biblioteca.menu.option.OptionWithSubOption;
import com.twu.biblioteca.menu.suboption.SubMenuOption;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Menu {

    private ArrayList<OptionWithSubOption> optionWithSubOptions;
    private ArrayList<Option> optionWithoutSubOptions;
    private Library library;
    public Menu(ArrayList<OptionWithSubOption> optionWithSubOptions,ArrayList<Option> optionWithoutSubOptions, Library Library) {
        this.optionWithSubOptions = optionWithSubOptions;
        this.optionWithoutSubOptions = optionWithoutSubOptions;
        this.library = Library;
    }

    public void executeMenu() {
        printAllOptions();
        String userInput = askUserForInput();
        if(userInput.length()>1){
            executeSubOption(getSubMenu(userInput));
        }else{
            executeOption(getOption(userInput));
        }


    }

    private SubMenuOption getSubMenu(String userInput) {
        if (isValidSubOption(userInput)) {
            return optionWithSubOptions.stream().filter(MenuOption -> MenuOption.getSubMenuCommands().contains(userInput)).collect(Collectors.toList()).get(0).getSubMenu(userInput);
        } else {
            System.out.println("Select a valid option!");
            printAllOptions();
            return getSubMenu(userInput);
        }

    }

    private Option getOption(String userInput){
        if(isValidOption(userInput)){
            return optionWithoutSubOptions.stream().filter(option -> userInput.equals(option.getCommand())).collect(Collectors.toList()).get(0);
        }else {
            System.out.println("Select a valid option!");
            printAllOptions();
            return getOption(userInput);
        }

    }

    private String askUserForInput(){
        Querist Querist = new Querist(System.in, System.out);
        return Querist.ask("Choose an option through typing and combining in the Letter within the brackets from left to right.").toString().trim();

    }

    private void executeSubOption(SubMenuOption Option){
        Option.processOption(library);
    }

    private void executeOption(Option Option){
        Option.processOption();
    }

    private void printOptionWithoutSubOption(){
        optionWithoutSubOptions.forEach(option -> System.out.println(option.getCommandContent()));
    }

    private void printOptionsWithSubOptions() {
        optionWithSubOptions.forEach(option -> System.out.println(option.getCommandContent()));
    }

    private void printAllOptions(){
        printOptionsWithSubOptions();
        printOptionWithoutSubOption();
    }

    private boolean isValidSubOption(String userInput) {
        return optionWithSubOptions.stream().anyMatch(MenuOption -> MenuOption.getSubMenuCommands().stream().anyMatch(input -> input.equals(userInput)));
    }

    private boolean isValidOption(String userInput) {
        return optionWithoutSubOptions.stream().anyMatch(option -> userInput.equals(option.getCommand()));
    }
}

