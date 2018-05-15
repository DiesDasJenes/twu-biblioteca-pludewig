package com.twu.biblioteca.support;

import com.twu.biblioteca.resources.Book;
import com.twu.biblioteca.dataprovider.FakeDataGenerator;
import com.twu.biblioteca.resources.Library;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private Book EndersGame;
    private Book EarthUnaware;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Before
    public void setUp() throws Exception {
        library = new Library(0);
        EndersGame = new Book("Enders Game","Orson Scoott",new org.joda.time.LocalDate(1990,12,1),true,"0");
        EarthUnaware = new Book("Earth Unaware","Orson Scoott",new org.joda.time.LocalDate(2005,4,14),true,"1");
        library.addBooks(EarthUnaware,EndersGame);
    }


    @Test
    public void getGeneratedBook() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FakeDataGenerator FDG = new FakeDataGenerator();
        Book b = FDG.generateMockDataForBook();
        assertTrue("Book is not null",b != null);
    }

    @Test
    public void canAddBooks(){
        assertTrue("Map contains 2 Books", library.getListOfAllBooks().size() == 2);
    }
}