package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.TableHeader;
import com.twu.biblioteca.resources.Library;

public class ListallBookOption implements Option {

    @Override
    public String getContent() {
        return "List all Books";
    }

    @Override
    public String getKey() {
        return "lB";
    }

    @Override
    public String execute(Library library) {
        TableHeader BH = new TableHeader();
        String BookList =BH.getBookHeader("%-20s");
        BookList = BookList.concat("\n");
        for (Book book: library.getListOfAllBooks().values()
                ) {
            if(book.isCheckedIn()){
                BookList = BookList.concat(String.format("%s", book.getPropertyList("%-20s")));
            }
        }

        return BookList;
    }
}
