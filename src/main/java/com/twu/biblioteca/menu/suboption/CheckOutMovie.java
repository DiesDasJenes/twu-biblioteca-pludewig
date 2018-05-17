package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class CheckOutMovie implements Option {
    private static int PERMISSION_LEVEL = 1;
    @Override
    public String getContent() {
        return "Please enter the Id of the movie you want to borrow.";
    }

    @Override
    public String getKey() {
        return "M";
    }

    @Override
    public String execute(Library library) {
        String input = new Querist(System.in,System.out).ask(getContent());
        if(library.getListOfAllMovies().containsKey(input) && library.getListOfAllMovies().get(input).isCheckedIn()){
            library.getListOfAllMovies().get(input).invertCheckedFlag();
            return "Thank you! Enjoy the movie";
        }else{
            return "That movie is not available.";
        }
    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }
}
