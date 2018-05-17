package com.twu.biblioteca.resources;

import java.util.Map;

public class Customer implements User {
    private String fullName;
    private String phoneNumber;
    private String emailAdress;
    private String loginLibraryNumber;
    private int passwordHash;
    private String id;
    public Customer(String loginLibraryNumber, int passwordHash, String phoneNumber, String emailAdress, String fullname){
        this.loginLibraryNumber = loginLibraryNumber;
        this.passwordHash = passwordHash;
        this.id = loginLibraryNumber;
        this.fullName = fullname;
        this.phoneNumber = phoneNumber;
        this.emailAdress = emailAdress;

    }

    public String getLoginLibraryNumber() {
        return loginLibraryNumber;
    }

    public int getPasswordHash() {
        return passwordHash;
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

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public int getPermission() {
        return 1;
    }
}
