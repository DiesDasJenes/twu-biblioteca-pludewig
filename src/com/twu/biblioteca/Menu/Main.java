package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Querist;

import java.util.Optional;

public class Main {

     private static final String OPTION_LIST_ALL_BOOKS = "List all Books";
     private static final String OPTION_QUIT = "Quit";

     public static void initiate(){
        displayandletUserchooseMainMenu_Option();
    }

    // show List of Optionen
    static void displayandletUserchooseMainMenu_Option(){
        Querist Querist = new Querist(System.in,System.out);
        while(true){
        printOptions();
        String answer = Querist.ask("Please choose an Option").toString().trim();
        switch(answer){
            case OPTION_LIST_ALL_BOOKS: break;
            case OPTION_QUIT: System.exit(1);
            default:
                System.out.println("Select a valid Option!");
        }
        }
    }

    private static void printOptions(){
        System.out.println("1. " + OPTION_LIST_ALL_BOOKS);
        System.out.println("2. " + OPTION_QUIT);
    }

}
