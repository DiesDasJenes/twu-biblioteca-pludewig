package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class CheckInBookOptionTest {

    private CheckInBookOption checkInBookOption;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() {
        checkInBookOption = new CheckInBookOption();
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("Please enter the ID of the book you want to return.", checkInBookOption.getCommandContent());
    }

    @Test
    public void canCheckInValidBook() {
        Library library = new Library();
        Book book = new Book("Enders Game", "Orson Scoott", new org.joda.time.LocalDate(1990, 12, 1), false, "0");
        library.addBooks(book);
        checkInBookOption.executeCommand(library, "0");
        assertEquals("Thank you for returning the book.\n", systemOutRule.getLog());
    }

    @Test
    public void cannotCheckInInvalidBook() {
        checkInBook("0");
    }

    @Test
    public void cannotCheckInNonExistentBook() {
        checkInBook("1");
    }

    private void checkInBook(String s) {
        Library library = new Library();
        Book book = new Book("Enders Game", "Orson Scoott", new org.joda.time.LocalDate(1990, 12, 1), true, "0");
        library.addBooks(book);
        checkInBookOption.executeCommand(library, s);
        assertEquals("That is not a valid book to return.\n", systemOutRule.getLog());
    }
}