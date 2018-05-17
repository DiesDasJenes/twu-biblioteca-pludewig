package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.suboption.ListallBookOption;
import com.twu.biblioteca.menu.suboption.ListallMoviesOption;
import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;



public class ListAllResources implements Option {

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
            case "B" : return new ListallBookOption().execute(library);
            case "M" : return new ListallMoviesOption().execute(library);
            case "A" : return "Abort";
            case "Q" : return new QuitOption().execute(library);
            default: execute(library);
        }
        return "Please select a valid option!";
    }
}
