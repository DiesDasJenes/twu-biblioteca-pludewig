package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckInBookTest {

    private CheckInBook checkInBook;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() {
        checkInBook = new CheckInBook();
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("Please enter the ID of the book you want to return.", checkInBook.getContent());
    }

    @Test
    public void canCheckInValidBook() {
        Library library = new Library();
        Book book = new Book("Enders Game", "Orson Scoott", new org.joda.time.LocalDate(1990, 12, 1), false, "0");
        library.addBooks(book);
        library.setCurrentCustomer(new Customer("111-1111","tw".hashCode(),"+49 09090990","sho@sho.com","Peter Lustig", null));
        systemInRule.provideLines("0");
        String actual = checkInBook.execute(library);
        assertEquals("Thank you for returning the book.", actual);
    }

    @Test
    public void cannotCheckInWhichIsCheckedOutBook() {
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
        systemInRule.provideLines(s);
        String actual = checkInBook.execute(library);
        assertEquals("That is not a valid book to return.", actual);
    }

    @Test
    public void shouldGetPermission(){
        assertTrue(checkInBook.isPermitted(1));
    }
}