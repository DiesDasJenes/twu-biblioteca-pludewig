package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class CheckOutResourceTest {
    CheckOutResource checkOutResource;
    Library library;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() throws Exception {
        checkOutResource = new CheckOutResource();
        library = new Library();
    }

    @Test
    public void getCommandContent() {
        assertEquals("What would you like to (b)orrow: (B)ook or (M)ovie", checkOutResource.getCommandContent());
    }

    @Test
    public void getCommand() {
        assertEquals("bB",checkOutResource.getCommand().get(0));
        assertEquals("bM",checkOutResource.getCommand().get(1));
    }

    @Test
    public void executeCommand() {
        assertNotNull(checkOutResource.executeCommand(library,"bB"));
        assertNotNull(checkOutResource.executeCommand(library,"bM"));
    }

    @Test
    public void processOption() {
        checkOutResource.processOption(library);
        assertEquals("What would you like to (b)orrow: (B)ook or (M)ovie",systemOutRule.getLog());
    }
}