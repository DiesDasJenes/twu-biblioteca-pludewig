package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Book;
import com.twu.biblioteca.support.BookHeader;
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
    public String displayRessources(Library Library) {
        BookHeader BH = new BookHeader();
        String BookList =BH.getHeader("%-20s");
        BookList = BookList.concat("\n");
        for (Book book: Library.getListOfAllBooks().values()
             ) {
            BookList = BookList.concat(String.format("%s", book.getPropertyList("%-20s")));
    }

        return BookList;
    }
}
