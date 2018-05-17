package com.twu.biblioteca.menu.topleveloption;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListOneResourceTest {
    private ListOneResource listOneResource;
    @Before
    public void setUp() throws Exception {
        listOneResource = new ListOneResource();
    }

    @Test
    public void getContent() {
        assertEquals("(D)isplay Item of Library",listOneResource.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("D",listOneResource.getKey());
    }

    @Test
    public void execute() {
    }


}