package com.twu.biblioteca.support;


import io.bloco.faker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Library extends Observable {
    private Map<Integer, Book> ListofAllBooks = new HashMap<>();
    private MockModel_Customer MockModel_Customer;
    public Library() {
        initiateBookList();
        MockModel_Customer = new MockModel_Customer();
    }

    private void initiateBookList () {
        for (int i = 0; i < 25 ; i++) {
            Book b = generateMockDataforBook();
            ListofAllBooks.putIfAbsent(b.getId(),b);
        }
    }

    private Book generateMockDataforBook() {
        Faker Faker = new Faker();
        return new Book(Faker.book.title(),new Author(Faker.name.firstName(),Faker.name.lastName()),Faker.date.birthday(),false,(int)(Math.random()*Integer.MAX_VALUE));
    }

    public Map<Integer, Book> getListofAllBooks() {
        return ListofAllBooks;
    }

    public void setBook(int key, Book Book) {
        ListofAllBooks.replace(key,Book);
        hasChanged();
        notifyObservers();
    }

    public MockModel_Customer getMockModel_Customer() {
        return MockModel_Customer;
    }

    public void setCustomer(int key, Customer Customer) {
        MockModel_Customer.getListofCustomers().replace(key,Customer);
        hasChanged();
        notifyObservers();
    }
}
