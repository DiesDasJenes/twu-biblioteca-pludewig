package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Movie;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class CheckInMovieTest {
    private static final String VALID_ID = "0";
    private static final String INVALID_ID = "1";
    private CheckInMovie checkInMovie;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        checkInMovie = new CheckInMovie();
    }

    @Test
    public void getContent() {
        assertEquals("Please enter the ID of the movie you want to return.",checkInMovie.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("M",checkInMovie.getKey());
    }

    @Test
    public void canCheckInValidMovie() {
        Library library = new Library();
        Movie movie= new Movie(VALID_ID, "Enders Game", new org.joda.time.LocalDate(1990, 12, 1), "Orson Scott",9,false);
        library.addMovies(movie);
        library.setCurrentCustomer(new Customer("111-1111","tw".hashCode(),"+49 09090990","sho@sho.com","Peter Lustig", null));
        systemInRule.provideLines(VALID_ID);
        String actual = checkInMovie.execute(library);
        assertEquals("Thank you for returning the movie.", actual);
    }

    @Test
    public void cannotCheckIWhichIsCheckedOutMovie() {
        checkInMovie(VALID_ID);
    }

    @Test
    public void cannotCheckInNonExistentMovie() {
        checkInMovie(INVALID_ID);
    }

    private void checkInMovie(String s) {
        Library library = new Library();
        Movie movie= new Movie(s, "Enders Game", new org.joda.time.LocalDate(1990, 12, 1), "Orson Scott",9,true);
        library.addMovies(movie);
        systemInRule.provideLines(s);
        String actual = checkInMovie.execute(library);
        assertEquals("That is not a valid movie to return.\n", actual);
    }

    @Test
    public void shouldGetPermission(){
        assertTrue(checkInMovie.isPermitted(1));
    }
}