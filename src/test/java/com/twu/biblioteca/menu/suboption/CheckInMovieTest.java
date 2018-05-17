package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Movie;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class CheckInMovieTest {
    private static final String VALID_ID = "0";
    private static final String INVALID_ID = "1";
    private CheckInMovie checkInMovie;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

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
        assertEquals("M",checkInMovie.getContent());
    }

    @Test
    public void canCheckInValidBook() {
        Library library = new Library();
        Movie movie= new Movie(VALID_ID, "Enders Game", new org.joda.time.LocalDate(1990, 12, 1), "Orson Scott",9,true);
        library.addMovies(movie);
        checkInMovie.execute(library);
        assertEquals("Thank you for returning the movie.\n", systemOutRule.getLog());
    }

    @Test
    public void cannotCheckInInvalidBook() {
        checkInBook(VALID_ID);
    }

    @Test
    public void cannotCheckInNonExistentBook() {
        checkInBook(INVALID_ID);
    }

    private void checkInBook(String s) {
        Library library = new Library();
        Movie movie= new Movie(VALID_ID, "Enders Game", new org.joda.time.LocalDate(1990, 12, 1), "Orson Scott",9,true);
        library.addMovies(movie);
        checkInMovie.execute(library);
        assertEquals("That is not a valid movie to return.\n", systemOutRule.getLog());
    }
}