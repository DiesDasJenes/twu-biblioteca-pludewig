package com.twu.biblioteca.resources;


import com.twu.biblioteca.dataprovider.FakeDataGenerator;
import com.twu.biblioteca.dataprovider.MockModel_Customer;

import java.util.Map;

public class Library {

    private static final int AMOUNT_OF_BOOKS = 25;
    private Map<String, Book> ListOfAllBooks;
    private com.twu.biblioteca.dataprovider.MockModel_Customer MockModel_Customer;

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


    public void addBooks(Book... books) {
        for (Book b : books
                ) {
            ListOfAllBooks.putIfAbsent(b.getBookId(), b);
        }
    }


    public Map<String, Book> getListOfAllBooks() {
        return ListOfAllBooks;
    }

}
