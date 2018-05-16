package com.twu.biblioteca.dataprovider;

import com.github.javafaker.Faker;
import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Resource;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FakeBookFactory implements FakeResourceFactory {
    private static final boolean CHECKED_IN = true;
    private static final String PREFIX = "B";

    public Map<String, Book> getBookList(int amount) {
        Map<String, Book> listOfAllBooks = new HashMap<>();
        for (int i = 0; i < amount; i++) {
            Book b = (Book) create();
            listOfAllBooks.putIfAbsent(b.getID(), b);
        }
        return listOfAllBooks;
    }

    @Override
    public Resource create() {
        Faker faker = new Faker(new Locale("en"));
        return new Book(faker.book().title(), faker.name().fullName(), LocalDate.now().minusYears((int) (Math.random() * 500)), CHECKED_IN, PREFIX + String.valueOf(faker.number().digit()));
    }

}
