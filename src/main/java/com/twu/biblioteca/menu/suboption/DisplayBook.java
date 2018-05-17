package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class DisplayBook implements Option {
    @Override
    public String getContent() {
        return "Please enter the Id of the book you want to see the details of.";
    }

    @Override
    public String getKey() {
        return "B";
    }

    @Override
    public String execute(Library library) {
        String id = new Querist(System.in,System.out).ask(this.getContent());
        if(library.getListOfAllBooks().containsKey(id)){
            Book Book = library.getListOfAllBooks().get(id);
            return  "\n" +
                    "Book Details:\n" +
                    "No." + Book.getID()  + "\n" +
                    "Title: " + Book.getTitle() + "\n" +
                    "Author: " + Book.getAuthor() + "\n" +
                    "Published: " + Book.getYearPublished() +
                    "\n";
        }
         return "Select a valid option!";
    }
}
