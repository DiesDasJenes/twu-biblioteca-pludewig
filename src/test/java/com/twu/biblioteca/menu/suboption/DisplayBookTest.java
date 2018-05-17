package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;

public class DisplayBookTest {
    private static final String BOOK_KEY = "26";
    private static final String BOOK_TITLE = "The Tea Rose";
    private static final String BOOK_AUTHOR = "Jennifer Donelly";
    private DisplayBook displayBook;
    private Library library;


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        displayBook = new DisplayBook();
        library = new Library();
        Book b = new Book(BOOK_TITLE, BOOK_AUTHOR, new LocalDate(2014, 1, 20), false, BOOK_KEY);
        library.addBooks(b);
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("Please enter the Id of the book you want to see the details of.", displayBook.getContent());
    }


    @Test
    public void shouldGetDetailsOfOneBook() {
        systemInRule.provideLines("26");
        String actual = displayBook.execute(library);
        assertEquals("\nBook Details:\n" +
                "No.26\n" +
                "Title: The Tea Rose\n" +
                "Author: Jennifer Donelly\n" +
                "Published: 2014\n",actual);

    }
}