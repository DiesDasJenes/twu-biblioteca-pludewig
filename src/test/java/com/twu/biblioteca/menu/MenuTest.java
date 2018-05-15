package com.twu.biblioteca.menu;

import com.twu.biblioteca.support.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {
    private Library library;
    private ListallBookOption listallBookOption;
    private Menu menu;


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Before
    public void setUp() throws Exception {
        library = new Library();
        listallBookOption = mock(ListallBookOption.class);
        when(listallBookOption.getCommand()).thenReturn("L");
        when(listallBookOption.getCommandContent()).thenReturn("(L)ist all Books");
        menu = new Menu(library,listallBookOption);
    }

    @Test
    public void printOptions() {
        menu.printOptions();
        assertEquals("(L)ist all Books\n",systemOutRule.getLog());
    }


    @Test
    public void canAddSeveralOptions(){
        Library library = new Library();
        ListallBookOption listallBookOption = mock(ListallBookOption.class);
        when(listallBookOption.getCommand()).thenReturn("L");
        when(listallBookOption.getCommandContent()).thenReturn("(L)ist all Books");
        QuitOption quitOption = mock(QuitOption.class);
        when(quitOption.getCommand()).thenReturn("Q");
        when(quitOption.getCommandContent()).thenReturn("Press (Q) to Quit");
        Menu menu = new Menu(library,listallBookOption,quitOption);
        menu.printOptions();
        assertEquals("(L)ist all Books\nPress (Q) to Quit\n",systemOutRule.getLog());
    }
}