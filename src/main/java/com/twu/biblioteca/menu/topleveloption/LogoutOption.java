package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;

public class LogoutOption implements Option {
    private static int PERMISSION_LEVEL = 1;
    @Override
    public String getContent() {
        return "(S)ign Out";
    }

    @Override
    public String getKey() {
        return "S";
    }

    @Override
    public String execute(Library library) {
        library.setCurrentCustomer(null);
        return "User logged out.";
    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }
}
