package com.twu.biblioteca.support;

import com.twu.biblioteca.dataprovider.FakeBookFactory;
import com.twu.biblioteca.dataprovider.FakeCustomerFactory;
import com.twu.biblioteca.dataprovider.FakeMovieFactory;
import com.twu.biblioteca.menu.option.*;
import com.twu.biblioteca.menu.suboption.*;
import com.twu.biblioteca.resources.Library;

import java.util.ArrayList;

public class Setup {

    public Library setUpLibrary(){
        Library library = new Library();
        FakeMovieFactory fakeMovieFactory = new FakeMovieFactory();
        FakeBookFactory fakeBookFactory = new FakeBookFactory();
        FakeCustomerFactory fakeCustomerFactory = new FakeCustomerFactory();
        library.setListOfAllMovies(fakeMovieFactory.getMovieList(25));
        library.setListOfAllBooks(fakeBookFactory.getBookList(25));
        library.setListOfAllCustomer(fakeCustomerFactory.getListOfCustomers(3));
        return library;
    }

    public ArrayList<OptionWithSubOption> setUpMenuOptions(){
        QuitOption QO = new QuitOption();
        ArrayList<OptionWithSubOption> Options= new ArrayList<>();
        Options.add(setUpListAllResourceOption());
        Options.add(setUpListOneResourceOption());
        Options.add(setUpCheckOutResourceOption());
        Options.add(setUpCheckInResourceOption());
        return Options;
    }

    private OptionWithSubOption setUpListAllResourceOption(){
        ListallBookOption LABO = new ListallBookOption();
        ListallMoviesOption LAMO = new ListallMoviesOption();
        return new ListAllResources(LABO,LAMO);
    }

    private OptionWithSubOption setUpCheckInResourceOption(){
        CheckInBookOption CIBO = new CheckInBookOption();
        return new CheckInResource(CIBO);
    }

    private OptionWithSubOption setUpCheckOutResourceOption(){
        CheckOutBookOption COBO = new CheckOutBookOption();
        return new CheckOutResource(COBO);
    }

    private OptionWithSubOption setUpListOneResourceOption(){
        ListOneBookOption LOBO = new ListOneBookOption();
        return new ListOneResource(LOBO);
    }


}
