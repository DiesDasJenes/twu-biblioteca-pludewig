package com.twu.biblioteca.menu.topleveloption;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckOutResourceTest {
    CheckOutResource checkOutResource;
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

    }
}