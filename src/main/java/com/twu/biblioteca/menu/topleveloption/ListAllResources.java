package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.suboption.ListallBooks;
import com.twu.biblioteca.menu.suboption.ListallMovies;
import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;



public class ListAllResources implements Option {
    private static int PERMISSION_LEVEL = 0;
    @Override
    public String getContent() {
        return "Display (L)ist of Library Equipment";
    }

    @Override
    public String getKey() {
        return "L";
    }

    @Override
    public String execute(Library library) {
        String userInput =  new Querist(System.in, System.out).ask("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit");
        switch (userInput){
            case "B" : return new ListallBooks().execute(library);
            case "M" : return new ListallMovies().execute(library);
            case "A" : return "Abort";
            case "Q" : return new QuitOption().execute(library);
            default: execute(library);
        }
        return "Please select a valid option!";
    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }
}
