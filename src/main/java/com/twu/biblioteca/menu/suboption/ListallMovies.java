package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Movie;
import com.twu.biblioteca.resources.TableHeader;

public class ListallMovies implements Option {

    @Override
    public String getContent() {
        return "List all Movies";
    }

    @Override
    public String getKey() {
        return "M";
    }

    @Override
    public String execute(Library library) {
        TableHeader TH = new TableHeader();
        String MovieList = TH.getMovieHeader("%-20s");
        MovieList = MovieList.concat("\n");
        for (Movie movie : library.getListOfAllMovies().values()
                ) {
            if (movie.isCheckedIn()) {
                MovieList = MovieList.concat(String.format("%s", movie.getPropertyList("%-20s")));
            }
        }

        return MovieList;
    }
}
