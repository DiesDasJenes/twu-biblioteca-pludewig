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

public class ListallMoviesTest {
    private ListallMovies listallMovies;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInRule = TextFromStandardInputStream.emptyStandardInputStream();


    @Before
    public void setUp() throws Exception {
        listallMovies = new ListallMovies();

    }

    @Test
    public void getCommandContent() {
        assertEquals("List all Movies", listallMovies.getContent());
    }

    @Test
    public void getCommand() {
        assertEquals("M", listallMovies.getKey());
    }

    @Test
    public void executeCommand() {
        Library library = new Library();
        Movie movie = new Movie("M0","The Running Man",new LocalDate(1990,10,14),"Arnold Normal",10,true);
        String test = "| Movie No.            | Title                | Author               | Published            | Rating               |\n| M0                   | The Running Man      | Arnold Normal        | 1990                 | 10/10                |\n";
        library.addMovies(movie);
        systemInRule.provideLines("M");
        String actual = listallMovies.execute(library);
        assertEquals(test,actual);
    }
}