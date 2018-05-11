package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Book;
import com.twu.biblioteca.support.BookHeader;
import com.twu.biblioteca.support.Library;

public class ListBookOption implements MenuOption {
    Library Library;
    public ListBookOption(Library library){
        this.Library = library;
    }
    @Override
    public String getCommandContent() {
        return "List all (B)ooks";
    }

    @Override
    public String getCommand() {
        return "B";
    }

    @Override
    public void executeCommand() {
        BookHeader BH = new BookHeader();
        String BookList =BH.getHeader("%-20s");
        BookList = BookList.concat("\n");
        for (Book book: Library.getListOfAllBooks().values()
             ) {
            BookList = BookList.concat(String.format("%s", book.getPropertyList("%-20s")));
    }

        System.out.println(BookList);
    }
}
