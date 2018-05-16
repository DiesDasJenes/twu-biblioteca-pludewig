package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ListAllResourcesTest {

    Library library;
    ListAllResources listAllResources;
    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        listAllResources = new ListAllResources();
    }

    @Test
    public void getCommandContent() {
        assertEquals("(S)how Details of: (B)ook or (M)ovie",listAllResources.getCommandContent());
    }

    @Test
    public void getCommand() {
        assertEquals("SB",listAllResources.getCommand());
    }

    @Test
    public void executeCommand() {
    }

    @Test
    public void processOption() {
    }
}