package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Movie;
import com.twu.biblioteca.resources.TableHeader;

public class ListallMoviesOption implements SubMenuOption {

    @Override
    public String getCommandContent() {
        return "List all Movies";
    }

    @Override
    public String getCommand() {
        return "lM";
    }

    @Override
    public void executeCommand(Library library, String input) {
        TableHeader TH = new TableHeader();
        String MovieList = TH.getMovieHeader("%-20s");
        MovieList = MovieList.concat("\n");
        for (Movie movie : library.getListOfAllMovies().values()
                ) {
            if (movie.isCheckedIn()) {
                MovieList = MovieList.concat(String.format("%s", movie.getPropertyList("%-20s")));
            }
        }

        System.out.println(MovieList);
    }

    @Override
    public void processOption(Library library) {
        executeCommand(library, null);
    }
}