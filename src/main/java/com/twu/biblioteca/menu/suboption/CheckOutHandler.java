package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Resource;
import com.twu.biblioteca.resources.User;

import java.util.HashMap;
import java.util.Map;

public class CheckOutHandler {

    static User getUpdatedCustomer(Library library, Resource resource){
        return new Customer(
                library.getCurrentCustomer().getLoginLibraryNumber(),
                library.getCurrentCustomer().getPasswordHash(),
                library.getCurrentCustomer().getPhoneNumber(),
                library.getCurrentCustomer().getEmailAdress(),
                library.getCurrentCustomer().getFullName(),
                returnResources(resource)
        );
    }

    private static Map<String,Resource> returnResources(Resource resource){
        Map<String,Resource> returnRes = new HashMap<>();
        returnRes.remove(resource);
        return returnRes;
    }
}
