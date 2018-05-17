package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class ListAllResourcesTest {
    private ListAllResources listAllResources;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        listAllResources = new ListAllResources();
    }

    @Test
    public void getContent() {
        assertEquals("Display (L)ist of Library Equipment", listAllResources.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("L", listAllResources.getKey());
    }

    @Test
    public void executeOption() {
        Library library = new Library();
        systemInRule.provideLines("B");
        String actual = listAllResources.execute(library);
        assertEquals("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit\n*", systemOutRule.getLog());
        assertEquals("| Book No.             | Title                | Author               | Published            |\n",actual);
    }

    @Test
    public void shouldDisplayOnBook(){
        Library library = new Library();
        Book b = new Book("The Hobbit","Henry Ford",new LocalDate(2011,2,23),true,"1");
        library.addBooks(b);
        systemInRule.provideLines("B");
        String actual = listAllResources.execute(library);
        assertEquals("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit\n*", systemOutRule.getLog());
        assertEquals("| Book No.             | Title                | Author               | Published            |\n| 1                    | The Hobbit           | Henry Ford           | 2011                 |\n",actual);
    }

}