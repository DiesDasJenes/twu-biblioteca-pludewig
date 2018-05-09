package com.twu.biblioteca.support;

public class Customer extends User {

    private static final int PERMISSION_CUSTOMER = 0;

    Customer(String firstname, String lastname, String loginName, int passwordHash, int id) {
        super(PERMISSION_CUSTOMER, firstname, lastname, loginName, passwordHash, id);
    }
}
