package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.resources.Library;
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
        assertEquals("Display (L)ist of Library Equipment",listAllResources.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("L",listAllResources.getKey());
    }

    @Test
    public void executeOption() {
        Library library = new Library();
        listAllResources.execute(library);
        assertEquals("* (B)ook\n* (M)ovie\n* (A)bort\n* (Q)uit",systemOutRule.getLog().substring(0,35));
        systemInRule.provideLines("Q");
    }
}