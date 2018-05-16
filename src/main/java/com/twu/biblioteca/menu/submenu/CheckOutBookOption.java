package com.twu.biblioteca.menu.submenu;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class CheckOutBookOption implements SubMenuOption {

    @Override
    public String getCommandContent() {
        return "Please enter the Id of the book you want to borrow.";
    }

    @Override
    public String getCommand() {
        return "bB";
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
        executeCommand(library,querist.ask(getCommandContent()).toString().trim());
    }



}