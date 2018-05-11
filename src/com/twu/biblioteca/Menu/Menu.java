package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Menu {

    private ArrayList<MenuOption> Options;
    private Library Library;
    public Menu(ArrayList<MenuOption> options,Library Library) {
        this.Options = options;
        this.Library = Library;
    }

    public void executeMenu() {
        printOptions();
        executeOption(askForOptions());
    }

    public MenuOption askForOptions() {
        Querist Querist = new Querist(System.in, System.out);
        String answer = Querist.ask("Choose an option through typing in the Letter within the brackets.").toString().trim();
        if (isValidOption(answer)) {
            return Options.stream()
                    .filter(option -> answer.equals(option.getCommand()))
                    .collect(Collectors.toList())
                    .get(0);
        } else {
            System.out.println("Select a valid option!");
            printOptions();
            return askForOptions();
        }

    }

    private void executeOption(MenuOption Option){
        Option.executeCommand(Library);
    }

    public void printOptions() {
        Options.forEach(option -> System.out.println(option.getCommandContent()));
    }

    private boolean isValidOption(String userInput) {
        return Options.stream().anyMatch(
                option -> userInput.equals(option.getCommand())
        );
    }
}

