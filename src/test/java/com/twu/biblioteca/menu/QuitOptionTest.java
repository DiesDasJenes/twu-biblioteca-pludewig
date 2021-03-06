package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.topleveloption.QuitOption;
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
        assertEquals("Press (Q) to Quit",quitOption.getContent());
    }

    @Test
    public void getCommand() {
        assertEquals("Q",quitOption.getKey());
    }
}