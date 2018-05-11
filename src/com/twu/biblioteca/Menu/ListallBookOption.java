package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Book;
import com.twu.biblioteca.support.BookHeader;
import com.twu.biblioteca.support.Library;

public class ListallBookOption implements MenuOption {

    @Override
    public String getCommandContent() {
        return "(L)ist all Books";
    }

    @Override
    public String getCommand() {
        return "L";
    }

    @Override
    public void executeCommand(Library Library) {
        BookHeader BH = new BookHeader();
        String BookList =BH.getHeader("%-20s");
        BookList = BookList.concat("\n");
        for (Book book: Library.getListOfAllBooks().values()
             ) {
            if(book.isCheckedIn()){
                BookList = BookList.concat(String.format("%s", book.getPropertyList("%-20s")));
            }
    }

        System.out.println(BookList);
    }
}
