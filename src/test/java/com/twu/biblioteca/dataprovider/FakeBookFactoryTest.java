package com.twu.biblioteca.dataprovider;

import com.twu.biblioteca.resources.Book;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FakeBookFactoryTest {
    @Test
    public void shouldCreateFakeBook() {
        FakeResourceFactory factory = new FakeBookFactory();
        Book book = (Book) factory.create();

        assertNotNull(book);
    }


}
