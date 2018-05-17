package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;

public class QuitOption implements Option {

    @Override
    public String getContent() {
        return "Press (Q) to Quit";
    }


    public String getKey() {
        return "Q";
    }

    public String execute(Library library) {
        System.exit(1);
        return "";
    }

    @Override
    public int getRequiredPermission() {
        return 0;
    }
}
