package com.twu.biblioteca.menu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuitOptionTest {

    private QuitOption quitOption;
    @Before
    public void setUp(){
        quitOption = new QuitOption();
    }
    @Test
    public void getCommandContent() {
        assertEquals("Press (Q) to Quit",quitOption.getCommandContent());
    }

    @Test
    public void getCommand() {
        assertEquals("Q",quitOption.getCommand().get(0));
    }
}