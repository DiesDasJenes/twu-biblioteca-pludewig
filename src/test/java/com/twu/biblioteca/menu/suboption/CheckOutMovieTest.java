package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Movie;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class CheckOutMovieTest {
    private static final String VALID_ID = "0";
    private static final String INVALID_ID = "1";
    private CheckOutMovie checkOutMovie;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

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
        checkOutMovie.execute(library);
        assertEquals("Thank you! Enjoy the movie\n", systemOutRule.getLog());
    }

    @Test
    public void cannotCheckOutInvalidBook() {
        checkOutMovie(VALID_ID);
    }

    private void checkOutMovie(String s) {
        Library library = new Library();
        Movie movie= new Movie(VALID_ID, "Enders Game", new org.joda.time.LocalDate(1990, 12, 1), "Orson Scott",9,true);
        library.addMovies(movie);
        checkOutMovie.execute(library);
        assertEquals("That movie is not available.\n", systemOutRule.getLog());
    }

    @Test
    public void cannotCheckOutNonExistingBook() {
        checkOutMovie(INVALID_ID);
    }
}