package com.twu.biblioteca.support;

import java.util.ArrayList;

public class User {
    private int Permission;
    private String Firstname;
    private String Lastname;
    private String LoginName;
    private int PasswordHash;
    private int Id;
    private ArrayList<Book> checkedOutBooks;


    User(int permission, String firstname, String lastname, String loginName, int passwordHash, int id) {
        Permission = permission;
        Firstname = firstname;
        Lastname = lastname;
        LoginName = loginName;
        PasswordHash = passwordHash;
        Id = id;
        checkedOutBooks = new ArrayList<>();
    }

    public int getPermission() {
        return Permission;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getLoginName() {
        return LoginName;
    }

    public int getPasswordHash() {
        return PasswordHash;
    }

    public int getId() {
        return Id;
    }

    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    @Override
    public String toString() {
        return "User: " +
                "Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", checkedOutBooks=" + checkedOutBooks;
    }
}