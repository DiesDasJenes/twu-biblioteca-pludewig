package com.twu.biblioteca.support;


import io.bloco.faker.Faker;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Integer, Book> ListofAllBooks = new HashMap<>();

    public Library() {
        initiateBookList();

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


}
