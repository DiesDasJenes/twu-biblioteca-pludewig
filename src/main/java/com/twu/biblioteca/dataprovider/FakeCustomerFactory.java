package com.twu.biblioteca.dataprovider;

import com.github.javafaker.Faker;
import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.User;

import java.util.HashMap;
import java.util.Map;

public class FakeCustomerFactory implements FakeUserFactory {

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
        return new Customer(String.valueOf((int)(Math.random()*Integer.MAX_VALUE)),Faker.name().firstName(),Faker.name().lastName(),"Cos1","TWiscool".hashCode());
    }
}
