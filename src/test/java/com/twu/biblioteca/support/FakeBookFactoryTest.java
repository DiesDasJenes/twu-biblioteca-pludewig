package com.twu.biblioteca.support;

import com.twu.biblioteca.dataprovider.FakeBookFactory;
import com.twu.biblioteca.dataprovider.FakeResourceFactory;
import com.twu.biblioteca.resources.Book;
import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class FakeBookFactoryTest {
    @Test
    public void shouldCreateFakeBook() {
        FakeResourceFactory factory = new FakeBookFactory();
        Book book = (Book) factory.create();

        assertNotNull(book);
    }

    @Test
    public void shouldCreateUniqueBooks() {
        FakeResourceFactory factory = new FakeBookFactory();
        Book book1 = (Book) factory.create();
        Book book2 = (Book) factory.create();

        assertNotEquals(book1.getID(), book2.getID());
    }
}
