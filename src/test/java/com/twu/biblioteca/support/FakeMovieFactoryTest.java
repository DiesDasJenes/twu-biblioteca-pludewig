package com.twu.biblioteca.support;

import com.twu.biblioteca.dataprovider.FakeMovieFactory;
import com.twu.biblioteca.dataprovider.FakeResourceFactory;
import com.twu.biblioteca.resources.Movie;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class FakeMovieFactoryTest {
    @Test
    public void shouldCreateFakeBook() {
        FakeResourceFactory factory = new FakeMovieFactory();
        Movie movie = (Movie) factory.create();

        assertNotNull(movie);
    }

    @Test
    public void shouldCreateUniqueBooks() {
        FakeResourceFactory factory = new FakeMovieFactory();
        Movie movie1 = (Movie) factory.create();
        Movie movie2 = (Movie) factory.create();

        assertNotEquals(movie1.getID(), movie2.getID());
    }
}
