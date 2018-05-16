package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;

public class CheckOutOption implements MenuOption {

    @Override
    public String getCommandContent() {
        return "(B)orrow a book";
    }

    @Override
    public String getCommand() {
        return "B";
    }

    @Override
    public void executeCommand(Library library, String input) {
        if(library.getListOfAllBooks().containsKey(input) && library.getListOfAllBooks().get(input).isCheckedIn()){
            library.getListOfAllBooks().get(input).invertCheckedFlag();
            System.out.println("Thank you! Enjoy the book");
        }else{
            System.out.println("That book is not available.");
        }
    }

    @Override
    public void processOption(Library library) {
        Querist querist = new Querist(System.in,System.out);
        String userInput = querist.ask("Please enter the Id of the book you want to see the details of.").toString().trim();
        executeCommand(library,userInput);
    }



}
