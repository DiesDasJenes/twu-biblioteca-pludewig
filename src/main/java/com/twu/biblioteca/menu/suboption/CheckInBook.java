package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class CheckInBook implements Option {
    private static int PERMISSION_LEVEL = 1;
    @Override
    public String getContent() {
        return "Please enter the ID of the book you want to return.";
    }

    @Override
    public String getKey() {
        return "B";
    }

    @Override
    public String execute(Library library) {
        String input = new Querist(System.in,System.out).ask(getContent());
        if(library.getListOfAllBooks().containsKey(input) && !library.getListOfAllBooks().get(input).isCheckedIn()){
            library.getListOfAllBooks().get(input).invertCheckedFlag();
            library.setCurrentCustomer((Customer) CheckInHandler.getUpdatedCustomer(library,library.getListOfAllBooks().get(input)));
            return "Thank you for returning the book.";
        }else{
            return "That is not a valid book to return.";
        }
    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }
}
