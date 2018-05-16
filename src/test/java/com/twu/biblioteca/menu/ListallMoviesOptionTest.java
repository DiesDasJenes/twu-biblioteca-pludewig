package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.submenu.ListallMoviesOption;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class ListallMoviesOptionTest {
    private ListallMoviesOption listallMoviesOption;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Before
    public void setUp() throws Exception {
        listallMoviesOption = new ListallMoviesOption();
    }

    @Test
    public void getCommandContent() {
        assertEquals("List all Movies",listallMoviesOption.getCommandContent());
    }

    @Test
    public void getCommand() {
        assertEquals("lM",listallMoviesOption.getCommand());
    }

    @Test
    public void executeCommand() {
        String test = "yadda yadda";
        assertEquals(test,systemOutRule.getLog());
    }

    @Test
    public void processOption() {
    }
}