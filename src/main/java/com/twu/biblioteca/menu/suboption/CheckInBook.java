package com.twu.biblioteca.menu.suboption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.resources.Resource;
import com.twu.biblioteca.resources.User;
import com.twu.biblioteca.support.Querist;

import java.util.HashMap;
import java.util.Map;

public class CheckInBook implements Option {
    private static int PERMISSION_LEVEL = 1;
    @Override
    public String getContent() {
        return "Please enter the ID of the book you want to return.";
    }

    @Override
    public String getKey() {
        return "B";
    }

    @Override
    public String execute(Library library) {
        String input = new Querist(System.in,System.out).ask(getContent());
        if(library.getListOfAllBooks().containsKey(input) && !library.getListOfAllBooks().get(input).isCheckedIn()){
            library.getListOfAllBooks().get(input).invertCheckedFlag();
            library.setCurrentCustomer((Customer) getCustomer(library,library.getListOfAllBooks().get(input)));
            return "Thank you for returning the book.";
        }else{
            return "That is not a valid book to return.";
        }
    }

    @Override
    public boolean isPermitted(int Permission) {
        return Permission >= PERMISSION_LEVEL;
    }

    private User getCustomer(Library library, Resource resource){
        return new Customer(
                library.getCurrentCustomer().getLoginLibraryNumber(),
                library.getCurrentCustomer().getPasswordHash(),
                library.getCurrentCustomer().getPhoneNumber(),
                library.getCurrentCustomer().getEmailAdress(),
                library.getCurrentCustomer().getFullName(),
                getBorrowedResources(resource)
        );
    }

    private Map<String,Resource> getBorrowedResources(Resource resource){
        Map<String,Resource> borrowedRes = new HashMap<>();
        borrowedRes.put(resource.getID(),resource);
        return borrowedRes;
    }

}
