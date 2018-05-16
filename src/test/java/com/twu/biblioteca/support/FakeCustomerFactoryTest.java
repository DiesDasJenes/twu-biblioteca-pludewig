package com.twu.biblioteca.support;

import com.twu.biblioteca.dataprovider.FakeDataFactory;
import com.twu.biblioteca.dataprovider.FakeUserFactory;
import com.twu.biblioteca.resources.Customer;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FakeCustomerFactoryTest {

    @Test
    public void shouldCreateFakeCustomer() {
        FakeDataFactory factory = new FakeUserFactory();
        Customer customer = (Customer) factory.create();

        assertNotNull(customer);
    }
}
