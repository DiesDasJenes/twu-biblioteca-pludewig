package com.twu.biblioteca.resources;


import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<String, Book> ListOfAllBooks;
    private Map<String, Customer> ListOfAllCustomer;

    public Library(){
        ListOfAllBooks = new HashMap<>();
        ListOfAllCustomer = new HashMap<>();
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

    public void setListOfAllBooks(Map<String, Book> listOfAllBooks) {
        ListOfAllBooks = listOfAllBooks;
    }

    public void setListOfAllCustomer(Map<String, Customer> listOfAllCustomer) {
        ListOfAllCustomer = listOfAllCustomer;
    }
}
