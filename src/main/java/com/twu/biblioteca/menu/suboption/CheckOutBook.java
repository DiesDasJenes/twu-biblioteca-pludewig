package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class CheckOutBook implements Option {
    private static int PERMISSION_LEVEL = 1;
    @Override
    public String getContent() {
        return "Please enter the Id of the book you want to borrow.";
    }

    @Override
    public String getKey() {
        return "B";
    }


    @Override
    public String execute(Library library) {
        String input = new Querist(System.in,System.out).ask(getContent());
        if(library.getListOfAllBooks().containsKey(input) && library.getListOfAllBooks().get(input).isCheckedIn()){
            library.getListOfAllBooks().get(input).invertCheckedFlag();
            return "Thank you! Enjoy the book";
        }else{
            return "That book is not available.";
        }
    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }
}
