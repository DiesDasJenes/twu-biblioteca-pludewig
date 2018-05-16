package com.twu.biblioteca.support;

import com.twu.biblioteca.dataprovider.FakeBookFactory;
import com.twu.biblioteca.dataprovider.FakeCustomerFactory;
import com.twu.biblioteca.dataprovider.FakeMovieFactory;
import com.twu.biblioteca.menu.ListAllResources;
import com.twu.biblioteca.menu.MenuOption;
import com.twu.biblioteca.menu.QuitOption;
import com.twu.biblioteca.menu.submenu.CheckInBookOption;
import com.twu.biblioteca.menu.submenu.CheckOutBookOption;
import com.twu.biblioteca.menu.submenu.ListOneBookOption;
import com.twu.biblioteca.menu.submenu.ListallBookOption;
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

    public ArrayList<MenuOption> setUpMenuOptions(){
        ListallBookOption LBO = new ListallBookOption();
        QuitOption QO = new QuitOption();
        ListOneBookOption LOBO = new ListOneBookOption();
        CheckOutBookOption COO = new CheckOutBookOption();
        CheckInBookOption CIO = new CheckInBookOption();
        ArrayList<MenuOption> Options= new ArrayList<>();
        // Options.add(LBO);  Options.add(LOBO);
        // Options.add(COO); Options.add(CIO);
        // Options.add(QO);
        return Options;
    }

    public MenuOption setUpListAllResourceOption(){
        ListallBookOption LBO = new ListallBookOption();
        ListAllResources listAllResources = new ListAllResources();
    }
}
