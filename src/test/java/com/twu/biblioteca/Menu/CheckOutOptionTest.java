package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Book;
import com.twu.biblioteca.support.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class CheckOutOptionTest {
    private static final String VALID_ID = "0";
    private static final String INVALID_ID = "1";
    private CheckOutOption checkOutOption;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() throws Exception {
        checkOutOption = new CheckOutOption();
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("(B)orrow a book", checkOutOption.getCommandContent());
    }

    @Test
    public void canGetCommand() {
        assertEquals("B",checkOutOption.getCommand());
    }

    @Test
    public void canCheckOutValidBook() {
        Library library = new Library(0);
        Book book = new Book("Enders Game","Orson Scoott",new org.joda.time.LocalDate(1990,12,1),true, VALID_ID);
        library.addBooks(book);
        checkOutOption.executeCommand(library,"0");
        assertEquals("Thank you! Enjoy the book\n",systemOutRule.getLog());
    }

    @Test
    public void cannotCheckOutInvalidBook() {
        checkOutBook(VALID_ID);
    }

    private void checkOutBook(String s) {
        Library library = new Library(0);
        Book book = new Book("Enders Game","Orson Scoott",new org.joda.time.LocalDate(1990,12,1),false,"0");
        library.addBooks(book);
        checkOutOption.executeCommand(library, s);
        assertEquals("That book is not available.\n",systemOutRule.getLog());
    }

    @Test
    public void cannotCheckOutNonExistingBook() {
        checkOutBook(INVALID_ID);
    }

}