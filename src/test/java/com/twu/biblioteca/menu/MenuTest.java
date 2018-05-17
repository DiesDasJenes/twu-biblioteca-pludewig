package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.suboption.ListallBooks;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {
    private Library library;
    private ListallBooks listallBooks;
    private Menu menu;


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Before
    public void setUp() throws Exception {
        library = new Library();
        listallBooks = mock(ListallBooks.class);
        when(listallBooks.getContent()).thenReturn("L");
        when(listallBooks.getContent()).thenReturn("(L)ist all Books");
        //menu = new Menu(library,listallBooks);
    }

    @Test
    public void printOptions() {
        //menu.printOptions();
        //assertEquals("(L)ist all Books\n",systemOutRule.getLog());
    }


    @Test
    public void shouldPrintInvailOptionText(){

    }

    @Test
    public void canAddSeveralOptions(){
        //Library library = new Library();
        //ListAllResources listAllResources = mock(ListAllResources.class);
        //ArrayList<String>
        //when(listAllResources.getSubMenuCommands()).thenReturn("L");
        //when(listAllResources.getContent()).thenReturn("(L)ist all Books");
        //QuitOption quitOption = mock(QuitOption.class);
        //when(quitOption.getSubMenuCommands()).thenReturn("Q");
        //when(quitOption.getContent()).thenReturn("Press (Q) to Quit");
        //Menu menu = new Menu(library,listallBooks,quitOption);
        //menu.printOptions();
        //assertEquals("(L)ist all Books\nPress (Q) to Quit\n",systemOutRule.getLog());
    }

}