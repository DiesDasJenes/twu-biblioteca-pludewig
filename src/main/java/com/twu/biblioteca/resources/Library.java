package com.twu.biblioteca.resources;


import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<String, Book> ListOfAllBooks;
    private Map<String, Movie> ListOfAllMovies;
    private Map<String, Customer> ListOfAllCustomer;
    private Customer currentCustomer;
    private int currentPermissionLevel;
    public Library(){
        ListOfAllBooks = new HashMap<>();
        ListOfAllMovies = new HashMap<>();
        ListOfAllCustomer = new HashMap<>();
        currentPermissionLevel = 0;
    }

    public void addBooks(Book... books) {
        for (Book b : books
                ) {
            ListOfAllBooks.putIfAbsent(b.getID(), b);
        }
    }

    public void addMovies(Movie... movies) {
        for (Movie m : movies
                ) {
            ListOfAllMovies.putIfAbsent(m.getID(), m);
        }
    }
    public Map<String, Book> getListOfAllBooks() {
        return ListOfAllBooks;
    }

    public Map<String, Customer> getListOfAllCustomer() {
        return ListOfAllCustomer;
    }

    public Map<String, Movie> getListOfAllMovies() {
        return ListOfAllMovies;
    }

    public void setListOfAllBooks(Map<String, Book> listOfAllBooks) {
        ListOfAllBooks = listOfAllBooks;
    }

    public void setListOfAllCustomer(Map<String, Customer> listOfAllCustomer) {
        ListOfAllCustomer = listOfAllCustomer;
    }

    public void setListOfAllMovies(Map<String, Movie> listOfAllMovies) {
        ListOfAllMovies = listOfAllMovies;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public int getCurrentPermissionLevel() {
        return currentPermissionLevel;
    }

    public void setCurrentPermissionLevel(int currentPermissionLevel) {
        this.currentPermissionLevel = currentPermissionLevel;
    }
}
