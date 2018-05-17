package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;

public class DisplayUser implements Option {
    @Override
    public String getContent() {
        return "Show (U)ser Information";
    }

    @Override
    public String getKey() {
        return "S";
    }

    @Override
    public String execute(Library library) {
        return null;
    }
}
