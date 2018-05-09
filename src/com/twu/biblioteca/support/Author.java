package com.twu.biblioteca.support;

public class Author {
    String Firstname;
    String Lastname;

    public Author(String firstname, String lastname) {
        Firstname = firstname;
        Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    @Override
    public String toString() {
        return "Author: " +
                "Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname;
    }
}
