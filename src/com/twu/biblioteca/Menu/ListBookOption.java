package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Book;
import com.twu.biblioteca.support.Library;

public class ListBookOption implements MenuOption {

    @Override
    public String getOptionContent() {
        return "List all (B)ooks";
    }

    @Override
    public String getCommand() {
        return "B";
    }

    @Override
    public void displayRessources(Library Library) {
        String BookList = Library.getListofAllBooks().get(1).propertyHeaders("%-20s");
        for (Book book: Library.getListofAllBooks().values()
             ) {
            BookList = BookList.concat(String.format("%s", book.propertyList("%-20s") ));
    }
    }
}
