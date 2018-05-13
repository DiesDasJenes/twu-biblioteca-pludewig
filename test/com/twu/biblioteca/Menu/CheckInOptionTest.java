package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Library;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CheckInOptionTest {

    private CheckInOption checkInOption;

    @Before
    public void setUp(){
        checkInOption = new CheckInOption();
    }

    @Test
    public void canGetCommandContent() {
        assertEquals("(R)eturn a Book",checkInOption.getCommandContent());
    }

    @Test
    public void canGetCommand() {
        assertEquals("R",checkInOption.getCommand());
    }

    @Test
    public void canCheckIn() {
        //Library library = mock(Library.class);
        //verify(checkInOption,times(1)).executeCommand(library);
    }

    @Test
    public  void cannotCheckInInvalidBoook(){
        // Book is taken
    }
}