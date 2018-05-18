package com.twu.biblioteca.support;

import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetupTest {
    private Setup setup;
    private Library library;
    @Before
    public void setUp() throws Exception {
        setup = new Setup();
        library = new Library();
    }

    @Test
    public void shouldSetUpLibrarywithFakeData() {
        assertNotNull(setup.setUpLibraryandFakeData(library));
    }

    @Test
    public void shouldSetUpMenuOptions() {
        assertNotNull(setup.setUpOptions(library));
    }

    @Test
    public void shouldSetUpCleanLibray() {
        assertNotNull(setup.setUpCleanLibray());
        assertTrue(setup.setUpCleanLibray().getListOfAllBooks().isEmpty());
    }
}