package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Book;
import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Querist;

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
    public void executeCommand(Library library) {
        Querist querist = new Querist(System.in,System.out);
        String answer = querist.ask("Please enter the Id of the book you want to see the details of.").toString().trim();
        if(library.getListOfAllBooks().containsKey(answer) && library.getListOfAllBooks().get(answer).isCheckedIn()){
            library.getListOfAllBooks().get(answer).invertCheckedFlag();
            System.out.println("Thank you! Enjoy the book");
        }else{
            System.out.println("That book is not available.");
        }
    }
}
