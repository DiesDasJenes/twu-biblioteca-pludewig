package com.twu.biblioteca.support;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SetupTest {
    private Setup setup;
    @Before
    public void setUp() throws Exception {
        setup = new Setup();
    }

    @Test
    public void shouldSetUpLibrarywithFakeData() {
        assertNotNull(setup.setUpLibraryandFakeData());
    }

    @Test
    public void shouldSetUpMenuOptions() {
        assertNotNull(setup.setUpOptions());
    }

    @Test
    public void shouldSetUpCleanLibray() {
        assertNotNull(setup.setUpCleanLibray());
        assertTrue(setup.setUpCleanLibray().getListOfAllBooks().isEmpty());
    }
}