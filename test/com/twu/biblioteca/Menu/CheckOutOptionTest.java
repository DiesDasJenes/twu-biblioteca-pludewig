package com.twu.biblioteca.Menu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckOutOptionTest {
    CheckOutOption checkOutOption;
    @Before
    public void setUp() throws Exception {
        checkOutOption = new CheckOutOption();
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("(B)orrow a book", checkOutOption.getCommandContent());
    }

    @Test
    public void canGetCommand() {
        assertEquals("B",checkOutOption);
    }

    @Test
    public void canCheckOutValidBook() {
    }

    @Test
    public void cannotCheckOutInvalidBook() {
    }
}