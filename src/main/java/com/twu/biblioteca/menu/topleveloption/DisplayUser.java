package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;

public class DisplayUser implements Option {
    private static int PERMISSION_LEVEL = 1;
    @Override
    public String getContent() {
        return "Show (U)ser Information";
    }

    @Override
    public String getKey() {
        return "U";
    }

    @Override
    public String execute(Library library) {

        if(library.getCurrentCustomer() != null){
            return  "\n" +
                    "User Details:\n" +
                    "No." + library.getCurrentCustomer().getID()  + "\n" +
                    "Name: " + library.getCurrentCustomer().getFullName() + "\n" +
                    "Email: " + library.getCurrentCustomer().getEmailAdress() + "\n" +
                    "Phonenumber: " + library.getCurrentCustomer().getPhoneNumber() +
                    "\n";
        }
        return "Select a valid option!";
    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }
}
