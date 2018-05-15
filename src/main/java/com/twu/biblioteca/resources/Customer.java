package com.twu.biblioteca.resources;

public class Customer {
    private String firstname;
    private String lastname;
    private String loginName;
    private int passwordHash;


    public Customer(String firstname, String lastname, String loginName, int passwordHash) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.loginName = loginName;
        this.passwordHash = passwordHash;
    }

    public String getLoginName() {
        return loginName;
    }

    public int getPasswordHash() {
        return passwordHash;
    }

    @Override
    public String toString() {
        return "Customer: " +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname;
    }
}
