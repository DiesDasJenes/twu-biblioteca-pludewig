package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AuthenticationOptionTest {
    private AuthenticationOption authenticationOption;
    private Library library;
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        library = new Library();
        authenticationOption = new AuthenticationOption(library);
    }

    @Test
    public void shouldGetContentofLogin() {
        assertNull(library.getCurrentCustomer());
        assertEquals("(S)ign Up",authenticationOption.getContent());
    }

    @Test
    public void shouldGetContentofLogout() {
        library.setCurrentCustomer(new Customer("1","tw".hashCode(),"s","a","Hein a"));
        assertNotNull(library.getCurrentCustomer());
        assertEquals("(S)ign Out",authenticationOption.getContent());
    }


    @Test
    public void shouldGetKeytofLogin() {
        assertNull(library.getCurrentCustomer());
        assertEquals("S",authenticationOption.getKey());
    }

    @Test
    public void shouldGetKeyofLogout() {
        library.setCurrentCustomer(new Customer("1","tw".hashCode(),"s","a","Hein a"));
        assertNotNull(library.getCurrentCustomer());
        assertEquals("S",authenticationOption.getKey());
    }

    @Test
    public void shouldGetPermissiontofLogin() {
        assertNull(library.getCurrentCustomer());
        assertTrue(authenticationOption.isPermitted(0));
    }

    @Test
    public void shouldGetPermissionofLogout() {
        library.setCurrentCustomer(new Customer("1","tw".hashCode(),"s","a","Hein a"));
        assertNotNull(library.getCurrentCustomer());
        assertTrue(authenticationOption.isPermitted(1));
    }
}