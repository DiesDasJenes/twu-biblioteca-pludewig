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
    public void setUpLibrary() {
        assertNotNull(setup.setUpLibrary());
    }

    @Test
    public void setUpMenuOptions() {
        assertNotNull(setup.setUpMenuOptions());
    }
}