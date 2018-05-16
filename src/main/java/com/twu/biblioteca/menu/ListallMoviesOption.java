package com.twu.biblioteca.menu;

import com.twu.biblioteca.resources.Library;

public class ListallMoviesOption implements SubMenuOption {

    @Override
    public String getCommandContent() {
        return "List all Movies";
    }

    @Override
    public void executeCommand(Library library, String input) {

    }

    @Override
    public void processOption(Library library) {

    }
}
