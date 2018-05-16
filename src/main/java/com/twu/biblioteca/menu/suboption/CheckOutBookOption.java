package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class CheckOutBookOption implements Option {

    @Override
    public String getCommandContent() {
        return "Please enter the Id of the book you want to borrow.";
    }

    @Override
    public String getCommand() {
        return "B";
    }


    @Override
    public String executeCommand(Library library) {
        String input = getUserInput();
        if(library.getListOfAllBooks().containsKey(input) && library.getListOfAllBooks().get(input).isCheckedIn()){
            library.getListOfAllBooks().get(input).invertCheckedFlag();
            return "Thank you! Enjoy the book";
        }else{
            return "That book is not available.";
        }
    }

    @Override
    public String getUserInput() {
        return new Querist(System.in,System.out).ask(getCommandContent());
    }


}
