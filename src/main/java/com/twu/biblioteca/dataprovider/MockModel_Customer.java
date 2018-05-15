package com.twu.biblioteca.dataprovider;

import com.twu.biblioteca.resources.Customer;
import io.bloco.faker.Faker;

import java.util.HashMap;

public class MockModel_Customer {
    private HashMap<Integer, Customer> ListofCustomers = new HashMap<>();

    public MockModel_Customer() {
        Faker Faker = new Faker();
        ListofCustomers.putIfAbsent((int) (Math.random() * Integer.MAX_VALUE), new Customer(Faker.name.firstName(), Faker.name.lastName(), "Cos1", "TWiscool".hashCode()));
        ListofCustomers.putIfAbsent((int) (Math.random() * Integer.MAX_VALUE), new Customer(Faker.name.firstName(), Faker.name.lastName(), "Cos2", "TWseemscool".hashCode()));
        ListofCustomers.putIfAbsent((int) (Math.random() * Integer.MAX_VALUE), new Customer(Faker.name.firstName(), Faker.name.lastName(), "Lib1", "Icantread".hashCode()));
    }

    public HashMap<Integer, Customer> getListofCustomers() {
        return ListofCustomers;
    }


}
