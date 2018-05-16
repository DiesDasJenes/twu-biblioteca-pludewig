package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class ListOneBookOption implements Option {
    @Override
    public String getCommandContent() {
        return "Please enter the Id of the book you want to see the details of.";
    }

    @Override
    public String getCommand() {
        return "B";
    }

    @Override
    public String executeCommand(Library library) {
        String id = new Querist(System.in,System.out).ask(this.getCommandContent());
        if(library.getListOfAllBooks().containsKey(id)){
            Book Book = library.getListOfAllBooks().get(id);
            return  "\n" +
                    "Book Details:\n" +
                    "No." + Book.getID()  + "\n" +
                    "Title: " + Book.getTitle() + "\n" +
                    "Author " + Book.getAuthor() + "\n" +
                    "Published " + Book.getYearPublished() +
                    "\n";
        }
         return "Select a valid option!";

    }

    @Override
    public String getUserInput() {
        return null;
    }


}
