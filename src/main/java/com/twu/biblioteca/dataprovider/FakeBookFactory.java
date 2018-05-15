package com.twu.biblioteca.dataprovider;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.resources.Resource;
import io.bloco.faker.Faker;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class FakeBookFactory implements FakeDataFactory {
    private static final boolean CHECKED_IN = true;

    public Map<String, Book> getBookList(int amount) {
        Map<String, Book> ListOfAllBooks = new HashMap<>();
        for (int i = 0; i < amount; i++) {
            Book b = (Book) create();
            ListOfAllBooks.putIfAbsent(b.getID(), b);
        }
        return ListOfAllBooks;
    }

    @Override
    public Resource create() {
        Faker Faker = new Faker();
        return new Book(Faker.book.title(), Faker.name.firstName().concat(" " + Faker.name.lastName()), LocalDate.now().minusYears((int) (Math.random() * 500)), CHECKED_IN, String.valueOf(Faker.number.positive()));
    }
}
