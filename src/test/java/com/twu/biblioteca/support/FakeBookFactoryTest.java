package com.twu.biblioteca.support;

import com.twu.biblioteca.dataprovider.FakeBookFactory;
import com.twu.biblioteca.dataprovider.FakeDataFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class FakeBookFactoryTest {
    @Test
    public void shouldCreateFakeBook() {
        FakeDataFactory factory = new FakeBookFactory();
        Book book = (Book) factory.create();

        assertNotNull(book);
    }

    @Test
    public void shouldCreateUniqueBooks() {
        FakeDataFactory factory = new FakeBookFactory();
        Book book1 = (Book) factory.create();
        Book book2 = (Book) factory.create();

        assertNotEquals(book1.getBookId(), book2.getBookId());
    }
}
