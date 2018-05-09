package com.twu.biblioteca.support_data;

public class Librarian extends User {

    private static final int PERMISSION_Librarian = 1;

    public Librarian(String firstname, String lastname, String loginName, String passwordHash, int id) {
        super(PERMISSION_Librarian, firstname, lastname, loginName, passwordHash, id);
    }
}
