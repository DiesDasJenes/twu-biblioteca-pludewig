package com.twu.biblioteca.menu.option;

import com.twu.biblioteca.menu.suboption.ListallBookOption;
import com.twu.biblioteca.menu.suboption.ListallMoviesOption;
import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;



public class ListAllResources implements Option {

    @Override
    public String getCommandContent() {
        return "(L)ist Resources";
    }

    @Override
    public String getCommand() {
        return "L";
    }

    @Override
    public String executeCommand(Library library) {
        String userInput = getUserInput();
        switch (userInput){
            case "B" : return new ListallBookOption().executeCommand(library);
            case "M" : return new ListallMoviesOption().executeCommand(library);
            case "A" : return "Abort";
            case "Q" : return new QuitOption().executeCommand(library);
            default: this.executeCommand(library);
        }
        return null;
    }

    @Override
    public String getUserInput() {
        return new Querist(System.in, System.out).ask("(B)ook\n(M)ovie\n(A)bort\n(Q)uit");
    }
}
