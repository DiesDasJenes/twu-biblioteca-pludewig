package com.twu.biblioteca.support;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

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
        //TODO Add Argument Text
        Method method = Library.class.getDeclaredMethod("generateMockDataForBook");
        method.setAccessible(true);
        Book b = (Book)method.invoke("");
        assertTrue("Book is not null",b != null);
    }

    @Test
    public void canAddBooks(){
        assertTrue("Map contains 2 Books", library.getListOfAllBooks().size() == 2);
    }
}