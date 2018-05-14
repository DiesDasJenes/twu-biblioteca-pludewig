package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Querist;

public class CheckInOption implements MenuOption {

    @Override
    public String getCommandContent() {
        return "(R)eturn a Book";
    }

    @Override
    public String getCommand() {
        return "R";
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
        executeCommand(library,querist.ask("Please enter the IDw of the book you want to see the details of.").toString().trim());
    }
}
