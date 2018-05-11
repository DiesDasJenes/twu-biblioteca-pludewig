package com.twu.biblioteca.support;

import io.bloco.faker.Faker;
import java.util.HashMap;

public class MockModel_Customer {
    private HashMap<Integer,Customer> ListofCustomers = new HashMap<>();

    public MockModel_Customer() {
        Faker Faker = new Faker();
        ListofCustomers.putIfAbsent((int)(Math.random()*Integer.MAX_VALUE),new Customer(Faker.name.firstName(),Faker.name.lastName(),"Cos1","TWiscool".hashCode(),(int)(Math.random()*Integer.MAX_VALUE)));
        ListofCustomers.putIfAbsent((int)(Math.random()*Integer.MAX_VALUE),new Customer(Faker.name.firstName(),Faker.name.lastName(),"Cos2","TWseemscool".hashCode(),(int)(Math.random()*Integer.MAX_VALUE)));
        ListofCustomers.putIfAbsent((int)(Math.random()*Integer.MAX_VALUE),new Customer(Faker.name.firstName(),Faker.name.lastName(),"Lib1","Icantread".hashCode(),(int)(Math.random()*Integer.MAX_VALUE)));
    }

    public HashMap<Integer, Customer> getListofCustomers() {
        return ListofCustomers;
    }


}
