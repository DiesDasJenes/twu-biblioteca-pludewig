package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Menu {


    private ArrayList<Option> optionTopLevel;
    private Library library;
    public Menu(ArrayList<Option> optionTopLevel, Library Library) {
        this.optionTopLevel = optionTopLevel;
        this.library = Library;
    }

    public void executeMenu() {
        printTopLevelOption();
        String userInput = askUserForInput();
        executeOption(getOption(userInput));
    }

    private Option getOption(String userInput){
        if(isValidOption(userInput)){
            return optionTopLevel.stream().filter(option -> userInput.equals(option.getCommand())).collect(Collectors.toList()).get(0);
        }else {
            System.out.println("Select a valid option!");
            printTopLevelOption();
            return getOption(userInput);
        }

    }

    private String askUserForInput(){
        Querist Querist = new Querist(System.in, System.out);
        return Querist.ask("Choose an option through typing and combining in the Letter within the brackets from left to right.").toString().trim();

    }
    private void executeOption(Option Option){
        System.out.println(Option.executeCommand(library));
    }

    private void printTopLevelOption(){
        optionTopLevel.forEach(option -> System.out.println(option.getCommandContent()));
    }

    private boolean isValidOption(String userInput) {
        return optionTopLevel.stream().anyMatch(option -> userInput.equals(option.getCommand()));
    }
}

