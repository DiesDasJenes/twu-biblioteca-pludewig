package com.twu.biblioteca.resources;

import java.util.Map;

public class Customer implements User {
    private String firstname;
    private String lastname;
    private String loginName;
    private int passwordHash;
    private String id;

    public Customer(String id, String firstname, String lastname, String loginName, int passwordHash){
        this.firstname = firstname;
        this.lastname = lastname;
        this.loginName = loginName;
        this.passwordHash = passwordHash;
        this.id = id;
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

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public void setID(String userID) {
        this.id = userID;
    }

    @Override
    public Map<String, Resource> getBorrowedResources() {
        return null;
    }
}
