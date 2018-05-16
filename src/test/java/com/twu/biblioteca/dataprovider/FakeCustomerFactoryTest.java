package com.twu.biblioteca.dataprovider;

import com.twu.biblioteca.dataprovider.FakeCustomerFactory;
import com.twu.biblioteca.dataprovider.FakeUserFactory;
import com.twu.biblioteca.resources.Customer;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class FakeCustomerFactoryTest {

    @Test
    public void shouldCreateFakeCustomer() {
        FakeUserFactory factory = new FakeCustomerFactory();
        Customer customer = (Customer) factory.create();

        assertNotNull(customer);
    }
}
