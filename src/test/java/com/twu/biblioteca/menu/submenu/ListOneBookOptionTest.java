package com.twu.biblioteca.menu.submenu;

import com.twu.biblioteca.menu.submenu.ListOneBookOption;
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
    public void shouldGetDetailsOfOneBook() {
        listOneBookOption.executeCommand(library,"26");
        assertEquals("",systemOutRule.getLog());

    }
}