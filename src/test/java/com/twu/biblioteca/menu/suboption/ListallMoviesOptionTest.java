package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Movie;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.*;

public class ListallMoviesOptionTest {
    private ListallMoviesOption listallMoviesOption;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Before
    public void setUp() throws Exception {
        listallMoviesOption = new ListallMoviesOption();

    }

    @Test
    public void getCommandContent() {
        assertEquals("List all Movies",listallMoviesOption.getCommandContent());
    }

    @Test
    public void getCommand() {
        assertEquals("lM",listallMoviesOption.getCommand());
    }

    @Test
    public void executeCommand() {
        Library library = new Library();
        Movie movie = new Movie("M0","The Running Man",new LocalDate(1990,10,14),"Arnold Normal",10,true);
        String test = "| Movie No.            | Title                | Author               | Published            | Rating               |\n| M0                   | The Running Man      | Arnold Normal        | 1990                 | 10/10                |\n\n";
        library.addMovies(movie);
        listallMoviesOption.executeCommand(library);
        assertEquals(test,systemOutRule.getLog());
    }

    @Test
    public void processOption() {
    }
}