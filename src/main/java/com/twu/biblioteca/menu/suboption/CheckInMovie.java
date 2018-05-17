package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class CheckInMovie implements Option {
    private static int PERMISSION_LEVEL = 1;
    @Override
    public String getContent() {
        return "Please enter the ID of the movie you want to return.";
    }

    @Override
    public String getKey() {
        return "M";
    }

    @Override
    public String execute(Library library) {
        String input = new Querist(System.in,System.out).ask(getContent());
        if(library.getListOfAllMovies().containsKey(input) && !library.getListOfAllMovies().get(input).isCheckedIn()){
            library.getListOfAllMovies().get(input).invertCheckedFlag();
            return "Thank you for returning the movie.";
        }else{
            return "That is not a valid movie to return.\n";
        }
    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }
}
