package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Movie;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.junit.Assert.*;

public class DisplayMoviesTest {
    private DisplayMovies displayMovies;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();

    @Before
    public void setUp() throws Exception {
        displayMovies = new DisplayMovies();
    }

    @Test
    public void shouldGetContent() {
        assertEquals("Please enter the Id of the movie you want to see the details of.",displayMovies.getContent());
    }

    @Test
    public void getKey() {
        assertEquals("M",displayMovies.getKey());
    }

    @Test
    public void execute() {
        Library library = new Library();
        Movie m = new Movie("M1","Star Trek",new LocalDate(2013,12,1),"Hani & Nani",3,true);
        library.addMovies(m);
        systemInRule.provideLines("M1");
        String actual = displayMovies.execute(library);
        assertEquals("\n" +
                "Movie Details:\n" +
                "No." + "M1"  + "\n" +
                "Title: " + "Star Trek" + "\n" +
                "Director: " + "Hani & Nani" + "\n" +
                "Published: " + "2013" +
                "Rating: " + "3" + "/10" +
                "\n",actual);
    }
}