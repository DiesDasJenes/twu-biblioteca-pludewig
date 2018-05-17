package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.menu.suboption.CheckInBook;
import com.twu.biblioteca.menu.suboption.CheckInMovie;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class CheckInResource implements Option {

    @Override
    public String getContent() {
        return "(R)eturn Item from Libary";
    }

    @Override
    public String getKey() {
        return "R";
    }

    @Override
    public String execute(Library library) {
        String userInput =  new Querist(System.in, System.out).ask("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit");
        switch (userInput){
            case "B" : return new CheckInBook().execute(library);
            case "M" : return new CheckInMovie().execute(library);
            case "A" : return "Abort";
            case "Q" : return new QuitOption().execute(library);
            default: execute(library);
        }
        return "Please select a valid option!";
    }

}
