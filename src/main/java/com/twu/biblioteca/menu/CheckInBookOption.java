package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;

public class CheckInBookOption implements SubMenuOption {

    @Override
    public String getCommandContent() {
        return "Please enter the ID of the book you want to return.";
    }


    @Override
    public void executeCommand(Library library, String input) {
        if(library.getListOfAllBooks().containsKey(input) && !library.getListOfAllBooks().get(input).isCheckedIn()){
            library.getListOfAllBooks().get(input).invertCheckedFlag();
            System.out.println("Thank you for returning the book.");
        }else{
            System.out.println("That is not a valid book to return.");
        }
    }

    @Override
    public void processOption(Library library) {
        Querist querist = new Querist(System.in,System.out);
        executeCommand(library,querist.ask(getCommandContent()).toString().trim());
    }
}
