package com.twu.biblioteca.support_data;

public class Customer extends User {

    private static final int PERMISSION_CUSTOMER = 0;

    Customer(int permission, String firstname, String lastname, String loginName, String passwordHash, int id) {
        super(PERMISSION_CUSTOMER, firstname, lastname, loginName, passwordHash, id);
    }
}
