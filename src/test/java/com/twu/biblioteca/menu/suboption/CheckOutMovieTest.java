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

public class CheckOutMovieTest {
    private static final String VALID_ID = "0";
    private static final String INVALID_ID = "1";
    private CheckOutMovie checkOutMovie;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        checkOutMovie = new CheckOutMovie();
    }

    @Test
    public void getContent() {
        assertEquals("Please enter the Id of the movie you want to borrow.",checkOutMovie.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("M",checkOutMovie.getKey());
    }

    @Test
    public void canCheckOutValidMovie() {
        Library library = new Library();
        Movie movie= new Movie(VALID_ID, "Enders Game", new org.joda.time.LocalDate(1990, 12, 1), "Orson Scott",9,true);
        library.addMovies(movie);
        library.setCurrentCustomer(new Customer("111-1111","tw".hashCode(),"+49 09090990","sho@sho.com","Peter Lustig", null));
        systemInRule.provideLines(VALID_ID);
        String actual = checkOutMovie.execute(library);
        assertEquals("Thank you! Enjoy the movie", actual);
    }

    @Test
    public void cannotCheckOutInvalidBook() {
        checkOutMovie(VALID_ID);
    }

    private void checkOutMovie(String s) {
        Library library = new Library();
        Movie movie= new Movie(VALID_ID, "Enders Game", new org.joda.time.LocalDate(1990, 12, 1), "Orson Scott",9,false);
        library.addMovies(movie);
        systemInRule.provideLines(s);
        String actual = checkOutMovie.execute(library);
        assertEquals("That movie is not available.", actual);
    }

    @Test
    public void cannotCheckOutNonExistingBook() {
        checkOutMovie(INVALID_ID);
    }

    @Test
    public void shouldGetPermission(){
        assertTrue(checkOutMovie.isPermitted(1));
    }
}