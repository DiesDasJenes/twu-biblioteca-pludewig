package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.menu.suboption.CheckOutBook;
import com.twu.biblioteca.menu.suboption.CheckOutMovie;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class CheckOutResource implements Option {
    private static int PERMISSION_LEVEL = 1;
    @Override
    public String getContent() {
        return "(B)orrow Item of Library Equipment";
    }

    @Override
    public String getKey() {
        return "B";
    }

    @Override
    public String execute(Library library) {
        String userInput =  new Querist(System.in, System.out).ask("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit");
        switch (userInput){
            case "B" : return new CheckOutBook().execute(library);
            case "M" : return new CheckOutMovie().execute(library);
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
