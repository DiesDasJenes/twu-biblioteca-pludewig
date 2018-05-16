package com.twu.biblioteca.dataprovider;

import com.twu.biblioteca.resources.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class FakeMovieFactoryTest {
    private FakeMovieFactory fakeMovieFactory;

    @Before
    public void setUp(){
        fakeMovieFactory = new FakeMovieFactory();
    }
    @Test
    public void shouldGetMovieList() {
        Map<String,Movie> movieList = fakeMovieFactory.getMovieList(25);
        assertNotNull(movieList);
    }

    @Test
    public void shouldCreateMovie() {
        Movie m = (Movie) fakeMovieFactory.create();
        assertNotNull(m);
    }
}