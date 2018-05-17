package com.twu.biblioteca.support;

import com.twu.biblioteca.dataprovider.FakeBookFactory;
import com.twu.biblioteca.dataprovider.FakeCustomerFactory;
import com.twu.biblioteca.dataprovider.FakeMovieFactory;
import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.menu.topleveloption.ListAllResources;
import com.twu.biblioteca.menu.topleveloption.QuitOption;
import com.twu.biblioteca.resources.Library;

import java.util.ArrayList;

public class Setup {

    public Library setUpLibraryandFakeData(){
        Library library = new Library();
        FakeMovieFactory fakeMovieFactory = new FakeMovieFactory();
        FakeBookFactory fakeBookFactory = new FakeBookFactory();
        FakeCustomerFactory fakeCustomerFactory = new FakeCustomerFactory();
        library.setListOfAllMovies(fakeMovieFactory.getMovieList(25));
        library.setListOfAllBooks(fakeBookFactory.getBookList(25));
        library.setListOfAllCustomer(fakeCustomerFactory.getListOfCustomers(3));
        return library;
    }

    public Library setUpCleanLibray(){
        return new Library();
    }


    public ArrayList<Option> setUpOptions(){
        QuitOption QO = new QuitOption();
        ListAllResources LAR = new ListAllResources();
        ArrayList<Option> TopLevelOption = new ArrayList<>();
        TopLevelOption.add(LAR);
        TopLevelOption.add(QO);

        return TopLevelOption;
    }


}
