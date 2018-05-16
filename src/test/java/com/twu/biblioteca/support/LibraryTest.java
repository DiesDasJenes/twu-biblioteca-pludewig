package com.twu.biblioteca.support;


import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void shouldAddBooks() {
        library = new Library();
        Book endersGame = new Book("Enders Game", "Orson Scoott", new org.joda.time.LocalDate(1990, 12, 1), true, "0");
        Book earthUnaware = new Book("Earth Unaware", "Orson Scoott", new org.joda.time.LocalDate(2005, 4, 14), true, "1");
        library.addBooks(earthUnaware, endersGame);
    }

    @Test
    public void shouldGetBookListWIthTwoItems() {
        assertEquals("Map contains 2 Books", 2, library.getListOfAllBooks().size());
    }
}