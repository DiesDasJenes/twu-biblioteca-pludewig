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

    public void execute() {
        printTopLevelOption();
        String userInput = getInput();
        printResultFor(getOption(userInput));
    }

    private Option getOption(String userInput){
        if(isValidOption(userInput)){
            return optionTopLevel.stream().filter(option -> userInput.equals(option.getKey())).collect(Collectors.toList()).get(0);
        }else {
            System.out.println("Select a valid option!");
            printTopLevelOption();
            return getOption(getInput());
        }
    }

    private String getInput(){
        Querist Querist = new Querist(System.in, System.out);
        return Querist.ask("Choose an option through typing in the Letter within the brackets.").trim();
    }
    private void printResultFor(Option Option){
        System.out.println(Option.execute(library));
    }

    private void printTopLevelOption(){
        optionTopLevel.forEach(option -> System.out.println(option.getContent()));
    }

    private boolean isValidOption(String userInput) {
        return optionTopLevel.stream().anyMatch(option -> userInput.equals(option.getKey()));
    }
}

