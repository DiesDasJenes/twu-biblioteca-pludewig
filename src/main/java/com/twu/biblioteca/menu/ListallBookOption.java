package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.BookHeader;
import com.twu.biblioteca.resources.Library;

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
    public void executeCommand(Library library, String input) {
        BookHeader BH = new BookHeader();
        String BookList =BH.getHeader("%-20s");
        BookList = BookList.concat("\n");
        for (Book book: library.getListOfAllBooks().values()
                ) {
            if(book.isCheckedIn()){
                BookList = BookList.concat(String.format("%s", book.getPropertyList("%-20s")));
            }
        }

        System.out.println(BookList);
    }

    @Override
    public void processOption(Library library) {
        executeCommand(library,null);
    }



}
