package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.suboption.ListallBooks;
import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Setup;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    private Library library;
    private ListallBooks listallBooks;
    private Menu menu;


    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();


    @Before
    public void setUp() throws Exception {
        Setup setup = new Setup();
        Library library = new Library();
        library.setCurrentCustomer(new Customer("111-1111","tw".hashCode(),"+49 09090990","sho@sho.com","Peter Lustig"));
        menu = new Menu(setup.setUpOptions(),library);
    }

    @Test
    public void printOptionsWithPermission() {
        //menu.printOptions();
        //assertEquals("(L)ist all Books\n",systemOutRule.getLog());
    }

    @Test
    public void printOptionsWithoutPermission() {
        systemInRule.provideLines("Q");
        menu.execute();
        assertEquals("(L)ist all Books\n",systemOutRule.getLog());
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