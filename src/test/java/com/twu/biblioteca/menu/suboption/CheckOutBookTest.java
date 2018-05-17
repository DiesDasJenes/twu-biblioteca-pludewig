package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class CheckOutBookTest {
    private static final String VALID_ID = "0";
    private static final String INVALID_ID = "1";
    private CheckOutBook checkOutBook;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() throws Exception {
        checkOutBook = new CheckOutBook();
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("Please enter the Id of the book you want to borrow.", checkOutBook.getContent());
    }

    @Test
    public void canCheckOutValidBook() {
        Library library = new Library();
        Book book = new Book("Enders Game", "Orson Scoott", new org.joda.time.LocalDate(1990, 12, 1), true, VALID_ID);
        library.addBooks(book);
        checkOutBook.execute(library);
        assertEquals("Thank you! Enjoy the book\n", systemOutRule.getLog());
    }

    @Test
    public void cannotCheckOutInvalidBook() {
        checkOutBook(VALID_ID);
    }

    private void checkOutBook(String s) {
        Library library = new Library();
        Book book = new Book("Enders Game", "Orson Scoott", new org.joda.time.LocalDate(1990, 12, 1), false, "0");
        library.addBooks(book);
        checkOutBook.execute(library);
        assertEquals("That book is not available.\n", systemOutRule.getLog());
    }

    @Test
    public void cannotCheckOutNonExistingBook() {
        checkOutBook(INVALID_ID);
    }

}