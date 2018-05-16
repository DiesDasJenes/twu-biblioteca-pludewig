package com.twu.biblioteca.dataprovider;

import com.github.javafaker.Faker;
import com.twu.biblioteca.resources.Movie;
import com.twu.biblioteca.resources.Resource;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class FakeMovieFactory implements FakeResourceFactory {
    private static final boolean CHECKED_IN = true;

    public Map<String, Movie> getMovieList(int amount) {
        Map<String, Movie> ListOfAllMovie = new HashMap<>();
        for (int i = 0; i < amount; i++) {
            Movie m = (Movie) create();
            ListOfAllMovie.putIfAbsent(m.getID(), m);
        }
        return ListOfAllMovie;
    }

    @Override
    public Resource create() {
        Faker faker = new Faker();
        return new Movie(faker.number().digit(),"Life at the " + faker.educator().university(),LocalDate.now().minusYears((int)(Math.random()*100)),faker.name().fullName(),(int)(Math.random()*10),CHECKED_IN);
    }
}
