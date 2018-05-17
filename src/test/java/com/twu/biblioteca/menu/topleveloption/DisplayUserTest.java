package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class DisplayUserTest {
    private DisplayUser displayUser;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        displayUser = new DisplayUser();
    }

    @Test
    public void getContent() {
        assertEquals("Show (U)ser Information",displayUser.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("U",displayUser.getKey());
    }

    @Test
    public void execute() {
        Library library = new Library();
        library.setCurrentCustomer(new Customer("111-1111","tw".hashCode(),"+49 09090990","sho@sho.com","Peter Lustig"));
        String actual = displayUser.execute(library);
        assertEquals("\n" +
                "User Details:\n" +
                "No." + "111-1111"  + "\n" +
                "Name: " + "Peter Lustig" + "\n" +
                "Email: " + "sho@sho.com" + "\n" +
                "Phonenumber: " + "+49 09090990" +
                "\n",actual);
    }

    @Test
    public void shouldGetPermission(){
        assertEquals(1,displayUser.getRequiredPermission());
    }
}