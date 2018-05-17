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

public class CheckOutResourceTest {
    CheckOutResource checkOutResource;
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        checkOutResource = new CheckOutResource();
    }

    @Test
    public void getCommandContent() {
        assertEquals("(B)orrow Item of Library Equipment",checkOutResource.getContent());
    }

    @Test
    public void getCommand() {
        assertEquals("B",checkOutResource.getKey());
    }

    @Test
    public void executeCommand() {
        Library library = new Library();
        library.addBooks(new Book("asd","",new LocalDate(1,1,1),false,"1"));
        systemInRule.provideLines("A");
        String actual = checkOutResource.execute(library);
        assertEquals("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit\n*", systemOutRule.getLog());
        assertEquals("Abort",actual);
    }

    @Test
    public void shouldGetPermission(){
        assertTrue(checkOutResource.isPermitted(1));
    }
}