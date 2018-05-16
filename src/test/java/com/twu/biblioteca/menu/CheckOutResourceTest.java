package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class CheckOutResourceTest {
    private CheckOutResource checkOutResource;


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Before
    public void setUp() throws Exception {
        checkOutResource = new CheckOutResource();
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
        assertNotNull(checkOutResource.executeCommand("bB"));
        assertNotNull(checkOutResource.executeCommand("bM"));
    }

    @Test
    public void processOption() {
        checkOutResource.processOption();
        assertEquals("What would you like to (b)orrow: (B)ook or (M)ovie",systemOutRule.getLog());
    }
}