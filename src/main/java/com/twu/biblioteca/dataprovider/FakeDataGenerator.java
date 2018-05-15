package com.twu.biblioteca.dataprovider;

import com.twu.biblioteca.resources.Book;
import io.bloco.faker.Faker;
import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.Map;

public class FakeDataGenerator {
    private static final boolean CHECKED_IN = true;

    FakeDataGenerator() {
    }

    Book generateMockDataForBook() {
        Faker Faker = new Faker();
        return new Book(Faker.book.title(),Faker.name.firstName().concat(" " + Faker.name.lastName()),LocalDate.now().minusYears((int)(Math.random()*500)), CHECKED_IN,String.valueOf(Faker.number.positive()));
    }

    Map<String, Book> initiateBookList (int amount) {
        Map<String, Book> ListOfAllBooks = new HashMap<String, Book>();
        for (int i = 0; i < amount ; i++) {
            Book b = generateMockDataForBook();
            ListOfAllBooks.putIfAbsent(b.getBookId(),b);
        }
        return ListOfAllBooks;
    }
}
