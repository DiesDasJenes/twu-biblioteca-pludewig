package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class ListOneBookOptionTest {
    private static final String BOOK_KEY = "26";
    private static final String BOOK_TITLE = "The Tea Rose";
    private static final String BOOK_AUTHOR = "Jennifer Donelly";
    public static final String SELECT_BOOK = "SB";
    public static final String SELECT_MOVIE = "SM";
    private ListOneBookOption listOneBookOption;
    private Library library;


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() throws Exception {
        listOneBookOption = new ListOneBookOption();
        library = new Library();
        Book b = new Book(BOOK_TITLE, BOOK_AUTHOR, new LocalDate(2014, 1, 20), false, BOOK_KEY);
        library.addBooks(b);
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("(S)how the Details of a Book", listOneBookOption.getCommandContent());
    }

    @Test
    public void canGetCommand() {
        assertEquals(SELECT_BOOK, listOneBookOption.getCommand().get(0));
        assertEquals(SELECT_MOVIE,listOneBookOption.getCommand().get(1));
    }

    @Test
    public void canGetDetailsofOneBook() {
        listOneBookOption.executeCommand(library, null);
        //TODO Mock INput set to One

    }
}