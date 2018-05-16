package com.twu.biblioteca.menu.submenu;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class ListOneBookOption implements SubMenuOption {
    @Override
    public String getCommandContent() {
        return "Please enter the Id of the book you want to see the details of.";
    }

    @Override
    public String getCommand() {
        return "lB";
    }

    @Override
    public void executeCommand(Library library, String input) {
        String id = input;
        if(library.getListOfAllBooks().containsKey(id)){
            Book Book = library.getListOfAllBooks().get(id);
            System.out.print("\n");
            System.out.println("Book Details:");
            System.out.println("No." + Book.getID());
            System.out.println("Title: " + Book.getTitle());
            System.out.println("Author " + Book.getAuthor());
            System.out.println("Published " + Book.getYearPublished());
            System.out.print("\n");
        }else{
            System.out.println("Select a valid option!");
        }
    }

    @Override
    public void processOption(Library library) {
        Querist querist = new Querist(System.in,System.out);
        executeCommand(library,querist.ask(this.getCommandContent()).toString().trim());
    }
}
