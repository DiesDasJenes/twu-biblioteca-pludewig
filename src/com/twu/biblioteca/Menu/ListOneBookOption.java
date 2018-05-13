package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Book;
import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Querist;

public class ListOneBookOption implements MenuOption {
    @Override
    public String getCommandContent() {
        return "(S)how the Details of a Book";
    }

    @Override
    public String getCommand() {
        return "S";
    }

    @Override
    public void executeCommand(Library library) {
        String id = getId(library);
        if(library.getListOfAllBooks().containsKey(id)){
            Book Book = library.getListOfAllBooks().get(id);
            System.out.print("\n");
            System.out.println("Book Details:");
            System.out.println("No." + Book.getBookId());
            System.out.println("Title: " + Book.getTitle());
            System.out.println("Author " + Book.getAuthor());
            System.out.println("Published " + Book.getYearPublished());
            System.out.print("\n");
        }else{
            System.out.println("Select a valid option!");
        }
    }

    private String getId(Library Library){
        Querist querist = new Querist(System.in,System.out);
        String answer = querist.ask("Please enter the Id of the book you want to see the details of.").toString().trim();
        return answer;
    }

}
