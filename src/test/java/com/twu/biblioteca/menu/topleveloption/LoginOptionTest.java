package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LoginOptionTest {
    private LoginOption loginOption;
    private Customer alice;
    private Customer bob;
    private Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        loginOption = new LoginOption();
        alice = new Customer("111-1110", "TWiscool".hashCode(),"as" ,"asd" ,"asd", null);
        bob = new Customer("222-2222", "tw2@".hashCode(), "asd", "asd", "asd", null);
        HashMap<String, Customer> List = new HashMap<>();
        List.putIfAbsent(alice.getID(), alice);
        List.putIfAbsent(bob.getID(), bob);
        library.setListOfAllCustomer(List);
    }

    @Test
    public void getContent() {
        assertEquals("(S)ign Up", loginOption.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("S", loginOption.getKey());
    }

    @Test
    public void execute() {

    }

    @Test
    public void shouldCheckCredentials() {
        assertTrue(loginOption.checkCredentials(library, alice.getLoginLibraryNumber(), "TWiscool"));
    }

    @Test
    public void shouldGetPermission(){
        assertTrue(loginOption.isPermitted(0));
    }
}