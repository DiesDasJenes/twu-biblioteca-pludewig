package com.twu.biblioteca.resources;

import com.twu.biblioteca.resources.BookHeader;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookHeaderTest {

    @Test
    public void getHeader() {
        BookHeader BH = new BookHeader();
        String test = String.format("| %-20s | %-20s | %-20s | %-20s |","Book No.","Title","Author","Published");
        assertEquals(test,BH.getHeader("%-20s"));
    }
}