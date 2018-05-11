package com.twu.biblioteca.support;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookHeaderTest {

    @Test
    public void getHeader() {
        BookHeader BH = new BookHeader();
        String test = String.format("| %-20s | %-20s | %-20s | %-20s | %-20s |","Book No.","Title","Author","Published","Available");
        assertEquals(test,BH.getHeader("%-20s"));
    }
}