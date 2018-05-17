package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class ListallBooksTest {
    private Library library;
    private ListallBooks listallBooks;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        library = new Library();
        listallBooks = new ListallBooks();
        Book b1 = new Book("Enders Game", "Orson Scoott", new org.joda.time.LocalDate(1990, 12, 1), true, "0");
        Book b2 = new Book("Earth Unaware", "Orson Scoott", new org.joda.time.LocalDate(2005, 4, 14), true, "1");
        library.addBooks(b1, b2);
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("List all Books", listallBooks.getContent());
    }


    @Test
    public void printAllBooks() {
        String actual = listallBooks.execute(library);
        assertEquals("| Book No.             | Title                | Author               | Published            |\n| 0                    | Enders Game          | Orson Scoott         | 1990                 |\n| 1                    | Earth Unaware        | Orson Scoott         | 2005                 |\n", actual);
    }
}