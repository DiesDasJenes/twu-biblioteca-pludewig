package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class ListallBookOptionTest {
    private Library library;
    private ListallBookOption listallBookOption;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() throws Exception {
        library = new Library(0);
        listallBookOption = new ListallBookOption();
        Book b1 = new Book("Enders Game","Orson Scoott",new org.joda.time.LocalDate(1990,12,1),true,"0");
        Book b2 = new Book("Earth Unaware","Orson Scoott",new org.joda.time.LocalDate(2005,4,14),true,"1");
        library.addBooks(b1,b2);
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("(L)ist all Books",listallBookOption.getCommandContent());
    }

    @Test
    public void canGetCommand() {
        assertEquals("L",listallBookOption.getCommand());
    }

    @Test
    public void printAllBooks() {
        listallBookOption.executeCommand(library,null);
        assertEquals("| Book No.             | Title                | Author               | Published            |\n| 0                    | Enders Game          | Orson Scoott         | 1990                 |\n| 1                    | Earth Unaware        | Orson Scoott         | 2005                 |\n\n",systemOutRule.getLog());
    }
}