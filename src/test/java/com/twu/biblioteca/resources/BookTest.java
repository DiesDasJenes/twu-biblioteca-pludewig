package com.twu.biblioteca.resources;

import com.github.javafaker.Faker;
import com.twu.biblioteca.resources.Book;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book TestBook;
    private String Author;
    private LocalDate randomYear;
    private String randomDigit;

    @Before
    public void setUp() throws Exception {
        Faker Faker = new Faker();
        String title = Faker.book().title();
        Author = Faker.name().fullName();
        randomYear = LocalDate.now().minusYears((int)(Math.random()*500));
        randomDigit = String.valueOf(Faker.number().digit());
        TestBook = new Book(title,Author,randomYear,true,randomDigit);
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
    public void TitleTooLong()  {
        Faker Faker = new Faker();
        Author = Faker.name().fullName();
        randomYear = LocalDate.now().minusYears((int)(Math.random()*500));
        randomDigit = String.valueOf(Faker.number().digit());
        String LongTitle = "THis is a really long Title which we want to reduce";
        String reducedTitle = "THis is a really ...";
        Book TestBook = new Book(LongTitle,Author,randomYear,false,randomDigit);

        assertEquals(reducedTitle,TestBook.getReducedTitle());
    }
}