package com.twu.biblioteca.dataprovider;

import com.twu.biblioteca.resources.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FakeCustomerFactoryTest {

    @Test
    public void shouldCreateFakeCustomer() {
        FakeUserFactory factory = new FakeCustomerFactory();
        Customer customer = (Customer) factory.create();
        assertNotNull(customer);
    }

    @Test
    public void shouldCreateFirstLoginCycle(){
        FakeUserFactory factory = new FakeCustomerFactory();
        Customer customer = (Customer) factory.create();
        assertEquals("111-1110",customer.getLoginName());
    }
}
