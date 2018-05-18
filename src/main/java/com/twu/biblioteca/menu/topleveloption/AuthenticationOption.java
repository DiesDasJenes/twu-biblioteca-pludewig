package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;

public class AuthenticationOption implements Option {
    private LoginOption login = new LoginOption();
    private LogoutOption logout = new LogoutOption();
    private Library library;
    public AuthenticationOption(Library library){
        this.library = library;
    }
    @Override
    public String getContent() {
        return getCurrentOption().getContent();
    }

    @Override
    public String getKey() {
        return getCurrentOption().getKey();
    }

    @Override
    public String execute(Library library) {
        return getCurrentOption().execute(library);
    }

    @Override
    public boolean isPermitted(int Permission) {
        return getCurrentOption().isPermitted(Permission);
    }

    private Option getCurrentOption(){
        if (library.getCurrentCustomer() == null) {
            return login;
        }else{
            return logout;
        }
    }
}
