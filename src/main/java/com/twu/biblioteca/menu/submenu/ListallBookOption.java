package com.twu.biblioteca.menu.submenu;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.BookHeader;
import com.twu.biblioteca.resources.Library;

public class ListallBookOption implements SubMenuOption {

    @Override
    public String getCommandContent() {
        return "List all Books";
    }

    @Override
    public String getCommand() {
        return "lB";
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