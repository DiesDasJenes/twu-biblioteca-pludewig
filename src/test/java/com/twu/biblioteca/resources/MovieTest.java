package com.twu.biblioteca.resources;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    private static final String ID = "0";
    private static final String TITLE = "The Hobbit";
    private static final LocalDate PUBLISHED = new LocalDate(2013, 5, 12);
    private static final String DIRECTOR = "Steven Seagull";
    private static final int FAULTY_RATING = 12;
    private static final int HIGHEST_RATING = 10;
    private Movie movie;

    @Before
    public void setUp() throws Exception {
        movie = new Movie(ID, TITLE, PUBLISHED, DIRECTOR, HIGHEST_RATING);
    }

    @Test
    public void getPropertyList() {
        String formatTestStr = String.format("| %1$s | %1$s | %1$s | %1$s | %1$s |%n", "%-20s");
        String test = String.format(formatTestStr,
                ID, TITLE,DIRECTOR,PUBLISHED.getYear(),HIGHEST_RATING
        );
        assertEquals(test,movie.getPropertyList("%-20s"));
    }

    @Test
    public void shouldNotInitialiseRatingOver10(){
        Movie movie = new Movie(ID, TITLE, PUBLISHED, DIRECTOR, FAULTY_RATING);
        assertEquals(10,movie.getRating());
    }

    @Test
    public void shouldReturnYear(){
        assertEquals(2013,movie.getYear());
    }
}