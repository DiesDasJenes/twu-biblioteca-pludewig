package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Menu {

    private ArrayList<MenuOption> Options;
    private ArrayList<Menu> subMenus;
    private Menu Parent;
    private String MenuName;

    Menu(ArrayList<MenuOption> options,Menu parent,ArrayList<Menu> subMenus,String name){
        this.Options = options;
        this.Parent = parent;
        this.subMenus = subMenus;
        this.MenuName = name;
    }

    public void executeMenu(){
        printOptions();
        askForOptions();
    }

    public void askForOptions(){
        Querist Querist = new Querist(System.in,System.out);
        String answer = Querist.ask("Please choose an Option").toString().trim();
        if (isValidOption(answer)) {
            MenuOption chosenOption = Options.stream()
                    .filter(option -> answer.equals(option.getCommand()))
                    .collect(Collectors.toList())
                    .get(0);
            chosenOption.executeCommand();
        } else {
            System.out.println("Choose an option through typing in the Letter within the brackets.");
            printOptions();
            askForOptions();
        }
    }

    public void printOptions(){
        int count = 1;
        Options.forEach(option -> System.out.println(option.getCommandContent()));
    }

    private boolean isValidOption(String userInput){
        return Options.stream().anyMatch(
                option -> userInput.equals(option.getCommand())
        );
    }

    public String getName(){
        return MenuName;
    }

    }

