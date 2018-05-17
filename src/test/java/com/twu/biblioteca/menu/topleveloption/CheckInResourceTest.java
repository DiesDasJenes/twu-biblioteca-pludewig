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

public class CheckInResourceTest {
    private CheckInResource checkInResource;
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        checkInResource = new CheckInResource();
    }

    @Test
    public void getContent() {
        assertEquals("(R)eturn Item from Libary",checkInResource.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("R",checkInResource.getKey());
    }

    @Test
    public void execute() {
        Library library = new Library();
        library.addBooks(new Book("","",new LocalDate(1,1,1),false,"1"));
        systemInRule.provideLines("A");
        String actual = checkInResource.execute(library);
        assertEquals("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit\n*", systemOutRule.getLog());
        assertEquals("Abort",actual);
    }

    @Test
    public void shouldGetPermission(){
        assertTrue(checkInResource.isPermitted(1));
    }
}