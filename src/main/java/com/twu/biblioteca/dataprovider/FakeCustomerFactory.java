package com.twu.biblioteca.dataprovider;

import com.github.javafaker.Faker;
import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.User;

import java.util.HashMap;
import java.util.Map;

public class FakeCustomerFactory implements FakeUserFactory {
    int count = 0;
    public Map<String, Customer> getListOfCustomers(int amount) {
        Map<String, Customer> ListOfAllCustomer = new HashMap<>();
        for (int i = 0; i < amount; i++) {
            Customer c = (Customer) create();
            ListOfAllCustomer.putIfAbsent(c.getID(), c);
        }
        return ListOfAllCustomer;
    }

    @Override
    public User create() {
        Faker Faker = new Faker();
        String loginCred = "111-111" + count++;
        return new Customer(loginCred,"tw".hashCode(),Faker.phoneNumber().phoneNumber(),Faker.internet().emailAddress(),Faker.name().fullName(), null);

    }
}
