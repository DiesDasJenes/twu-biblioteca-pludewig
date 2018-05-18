package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Resource;
import com.twu.biblioteca.resources.User;

import java.util.HashMap;
import java.util.Map;

class CheckInHandler {

    static User getUpdatedCustomer(Library library, Resource resource){
        return new Customer(
                library.getCurrentCustomer().getLoginLibraryNumber(),
                library.getCurrentCustomer().getPasswordHash(),
                library.getCurrentCustomer().getPhoneNumber(),
                library.getCurrentCustomer().getEmailAdress(),
                library.getCurrentCustomer().getFullName(),
                borrowResources(resource)
        );
    }

    private static Map<String,Resource> borrowResources(Resource resource){
        Map<String,Resource> borrowedRes = new HashMap<>();
        borrowedRes.put(resource.getID(),resource);
        return borrowedRes;
    }
}
