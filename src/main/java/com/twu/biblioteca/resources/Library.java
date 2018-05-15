package com.twu.biblioteca.resources;


import com.twu.biblioteca.dataprovider.FakeBookFactory;
import com.twu.biblioteca.dataprovider.FakeUserFactory;

import java.util.Map;

public class Library {

    private static final int AMOUNT_OF_BOOKS = 25;
    private static final int AMOUNT_OF_CUSTOMER = 1;
    private Map<String, Book> ListOfAllBooks;
    private Map<String, Customer> ListOfAllCustomer;

    public Library() {
        FakeBookFactory FDG = new FakeBookFactory();
        ListOfAllBooks = FDG.getBookList(AMOUNT_OF_BOOKS);
        FakeUserFactory FUF = new FakeUserFactory();
        ListOfAllCustomer = FUF.getListOfCustomers(AMOUNT_OF_CUSTOMER);
    }

    public void addBooks(Book... books) {
        for (Book b : books
                ) {
            ListOfAllBooks.putIfAbsent(b.getID(), b);
        }
    }
    public Map<String, Book> getListOfAllBooks() {
        return ListOfAllBooks;
    }

    public Map<String, Customer> getListOfAllCustomer() {
        return ListOfAllCustomer;
    }
}
