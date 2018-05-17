package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Movie;
import com.twu.biblioteca.support.Querist;

public class DisplayMovies implements Option {
    private static int PERMISSION_LEVEL = 0;
    @Override
    public String getContent() {
        return "Please enter the Id of the movie you want to see the details of.";
    }

    @Override
    public String getKey() {
        return "M";
    }

    @Override
    public String execute(Library library) {
        String id = new Querist(System.in,System.out).ask(this.getContent());
        if(library.getListOfAllMovies().containsKey(id)){
            Movie movie = library.getListOfAllMovies().get(id);
            return  "\n" +
                    "Movie Details:\n" +
                    "No." + movie.getID()  + "\n" +
                    "Title: " + movie.getTitle() + "\n" +
                    "Director: " + movie.getDirector() + "\n" +
                    "Published: " + movie.getYear() +
                    "Rating: " + movie.getRating() + "/10" +
                    "\n";
        }
        return "Select a valid option!";

    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }
}
