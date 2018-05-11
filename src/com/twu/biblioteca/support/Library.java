package com.twu.biblioteca.support;


import io.bloco.faker.Faker;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class Library extends Observable {
    private static final boolean CHECKED_IN = true;
    private Map<String, Book> ListOfAllBooks = new HashMap<String, Book>();
    private MockModel_Customer MockModel_Customer;
    public Library() {
        initiateBookList();
        MockModel_Customer = new MockModel_Customer();
    }

    private void initiateBookList () {
        for (int i = 0; i < 25 ; i++) {
            Book b = generateMockDataForBook();
            ListOfAllBooks.putIfAbsent(b.getBookId(),b);
        }
    }

    private Book generateMockDataForBook() {
        Faker Faker = new Faker();
        return new Book(Faker.book.title(),Faker.name.firstName().concat(" " + Faker.name.lastName()),LocalDate.now().minusYears((int)(Math.random()*500)), CHECKED_IN,String.valueOf(Faker.number.positive()));
    }

    public Map<String, Book> getListOfAllBooks() {
        return ListOfAllBooks;
    }

    public void setBook(String key, Book Book) {
        ListOfAllBooks.replace(key,Book);
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
