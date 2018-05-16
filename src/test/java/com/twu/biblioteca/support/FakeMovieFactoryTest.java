package com.twu.biblioteca.support;

import com.twu.biblioteca.dataprovider.FakeMovieFactory;
import com.twu.biblioteca.dataprovider.FakeResourceFactory;
import com.twu.biblioteca.resources.Movie;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FakeMovieFactoryTest {
    @Test
    public void shouldCreateFakeBook() {
        FakeResourceFactory factory = new FakeMovieFactory();
        Movie movie = (Movie) factory.create();

        assertNotNull(movie);
    }
}
