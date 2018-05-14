package com.twu.biblioteca.support;


import io.bloco.faker.Faker;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Map;
public class Library  {

    private static final int AMOUNT_OF_BOOKS = 25;
    private Map<String, Book> ListOfAllBooks;
    private MockModel_Customer MockModel_Customer;
    public Library() {
        FakeDataGenerator FDG = new FakeDataGenerator();
        ListOfAllBooks = FDG.initiateBookList(AMOUNT_OF_BOOKS);
        MockModel_Customer = new MockModel_Customer();
    }

    public Library(int amount) {
        FakeDataGenerator FDG = new FakeDataGenerator();
        ListOfAllBooks = FDG.initiateBookList(amount);
        MockModel_Customer = new MockModel_Customer();
    }



    public void addBooks(Book... books){
        for (Book b:books
             ) {
            ListOfAllBooks.putIfAbsent(b.getBookId(),b);
        }
    }



    public Map<String, Book> getListOfAllBooks() {
        return ListOfAllBooks;
    }

    public void setBook(String key, Book Book) {
        ListOfAllBooks.replace(key,Book);
    }

    public void setCustomer(int key, Customer Customer) {
        MockModel_Customer.getListofCustomers().replace(key,Customer);
    }
}
