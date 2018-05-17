package com.twu.biblioteca.menu.topleveloption;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckInResourceTest {
    private CheckInResource checkInResource;
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
    }
}