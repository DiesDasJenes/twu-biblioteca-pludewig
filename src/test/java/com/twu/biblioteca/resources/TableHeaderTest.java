package com.twu.biblioteca.resources;

import org.junit.Test;

import static org.junit.Assert.*;

public class TableHeaderTest {

    @Test
    public void getHeader() {
        TableHeader BH = new TableHeader();
        String test = String.format("| %-20s | %-20s | %-20s | %-20s |","Book No.","Title","Author","Published");
        assertEquals(test,BH.getBookHeader("%-20s"));
    }
}