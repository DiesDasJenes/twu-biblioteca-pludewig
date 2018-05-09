package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class menu_mainTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void printWelcomeMessage() {
        Menu_main.printWelcomeMessage();

        assertEquals("##########################################\n#\t\t\t\tBiblioteca\t\t\t\t#\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n#\t\tNihil Sciemus Sed Est Exiguus\t#\n##########################################\n\t\t\t   We welcome you",systemOutRule.getLog().substring(0,205));
    }
}