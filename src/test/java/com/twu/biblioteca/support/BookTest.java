package com.twu.biblioteca.support;

import io.bloco.faker.Faker;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class BookTest {

    private Book TestBook;
    private String Title;
    private String Author;
    private LocalDate randomYear;
    private String randomDigit;

    @Before
    public void setUp() throws Exception {
        Faker Faker = new Faker();
        Title = Faker.book.title();
        Author = Faker.name.firstName() + Faker.name.lastName();
        randomYear = LocalDate.now().minusYears((int)(Math.random()*500));
        randomDigit = String.valueOf(Faker.number.positive());
        TestBook = new Book(Title,Author,randomYear,true,randomDigit);
    }

    @Test
    public void propertyList() {
        String formatTestStr = String.format("| %1$s | %1$s | %1$s | %1$s |%n", "%-20s");
        String test = String.format(formatTestStr,
                randomDigit, TestBook.getReducedTitle(),Author, randomYear.getYear()
        );
        assertEquals(test,TestBook.getPropertyList("%-20s"));
    }

    @Test
    public void TitleTooLong() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Faker Faker = new Faker();
        Author = Faker.book.author();
        randomYear = LocalDate.now().minusYears((int)(Math.random()*500));
        randomDigit = String.valueOf(Faker.number.positive());
        String LongTitle = "THis is a really long Title which we want to reduce";
        String reducedTitle = "THis is a really ...";
        Book TestBook = new Book(LongTitle,Author,randomYear,false,randomDigit);

        assertEquals(reducedTitle,TestBook.getReducedTitle());
    }
}