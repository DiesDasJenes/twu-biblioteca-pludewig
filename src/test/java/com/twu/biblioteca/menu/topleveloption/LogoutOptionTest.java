package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogoutOptionTest {
    private LogoutOption logoutOption;
    @Before
    public void setUp() throws Exception {
        logoutOption = new LogoutOption();
    }

    @Test
    public void getContent() {
        assertEquals("(S)ign Out",logoutOption.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("S",logoutOption.getKey());
    }

    @Test
    public void execute() {
        Library library =  new Library();
        library.setCurrentCustomer(new Customer("a","asd".hashCode(),"asd","asd","asd asd", null));
        assertNotNull(library.getCurrentCustomer());
        logoutOption.execute(library);
        assertNull(library.getCurrentCustomer());
    }

    @Test
    public void isPermitted() {
        assertTrue(logoutOption.isPermitted(1));
    }
}