package com.twu.biblioteca.support;

import io.bloco.faker.Faker;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class BookTest {

    Book TestBook;
    String Title;
    String Author;
    LocalDate randomYear;
    String randomDigit;

    @Before
    public void setUp() throws Exception {
        Faker Faker = new Faker();
        Title =Faker.book.title();
        Author = Faker.book.author();
        randomYear = LocalDate.now().minusYears((int)(Math.random()*500));
        randomDigit = String.valueOf(Faker.number.positive());
        TestBook = new Book(Title,Author,randomYear,false,randomDigit);
    }

    @Test
    public void propertyList() {


        String formatTestStr = String.format("| %1$s | %1$s | %1$s | %1$s | %1$s |%n", "%-20s");
        String test = String.format(formatTestStr,
                randomDigit, Title,Author, randomYear.getYear(), true
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

        Method method = Book.class.getDeclaredMethod("reduceTitle");
        method.setAccessible(true);
        assertEquals(reducedTitle,method.invoke(TestBook));
    }
}