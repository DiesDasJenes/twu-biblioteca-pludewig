package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class ListAllResourcesTest {
    ListAllResources listAllResources;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        listAllResources = new ListAllResources();
    }

    @Test
    public void getCommandContent() {
        assertEquals("Display (L)ist of Resources",listAllResources.getCommandContent());
    }

    @Test
    public void getCommand() {
        assertEquals("L",listAllResources.getCommand());
    }

    @Test
    public void executeCommand() {
        Library library = new Library();
        listAllResources.executeCommand(library);
        assertEquals("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit",systemOutRule.getLog().substring(0,35));
        systemInRule.provideLines("Q");
    }
}