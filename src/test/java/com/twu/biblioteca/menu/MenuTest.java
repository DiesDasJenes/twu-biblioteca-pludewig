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
        library = new Library();
        library.setCurrentCustomer(new Customer("111-1111","tw".hashCode(),"+49 09090990","sho@sho.com","Peter Lustig", null));
        menu = new Menu(setup.setUpOptions(library),library);
    }

    @Test
    public void printOptionsWithPermission() {
        menu.printTopLevelOption();
        library.setCurrentPermissionLevel(1);
        assertEquals("Display (L)ist of Library Equipment\n" +
                "(D)isplay Item of Library\n" +
                "(S)ign Up\n" +
                "Press (Q) to Quit\n",systemOutRule.getLog());
    }

    @Test
    public void printOptionsWithoutPermission() {
        systemInRule.provideLines("Q");
        menu.printTopLevelOption();
        assertEquals("Display (L)ist of Library Equipment\n" +
                "(D)isplay Item of Library\n" +
                "(S)ign Up\n" +
                "Press (Q) to Quit\n",systemOutRule.getLog());
    }
}