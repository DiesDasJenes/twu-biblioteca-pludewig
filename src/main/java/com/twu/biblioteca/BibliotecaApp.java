package com.twu.biblioteca;

import com.twu.biblioteca.dataprovider.FakeBookFactory;
import com.twu.biblioteca.dataprovider.FakeCustomerFactory;
import com.twu.biblioteca.dataprovider.FakeMovieFactory;
import com.twu.biblioteca.menu.*;
import com.twu.biblioteca.menu.submenu.CheckInBookOption;
import com.twu.biblioteca.menu.submenu.CheckOutBookOption;
import com.twu.biblioteca.menu.submenu.ListOneBookOption;
import com.twu.biblioteca.menu.submenu.ListallBookOption;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Messages;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp Biblioteca = new BibliotecaApp();
        Biblioteca.run();
    }

    private void run(){
        Messages.printWelcomeMessage();
        Menu MainMenu = setUpMenu();
        while(true){
            MainMenu.executeMenu();
        }
    }

    private Menu setUpMenu() {
        return new Menu(setUpOptions(),setUpLibrary());
    }

    private Library setUpLibrary(){
        Library library = new Library();
        FakeMovieFactory fakeMovieFactory = new FakeMovieFactory();
        FakeBookFactory fakeBookFactory = new FakeBookFactory();
        FakeCustomerFactory fakeCustomerFactory = new FakeCustomerFactory();
        library.setListOfAllMovies(fakeMovieFactory.getMovieList(25));
        library.setListOfAllBooks(fakeBookFactory.getBookList(25));
        library.setListOfAllCustomer(fakeCustomerFactory.getListOfCustomers(3));
        return library;
    }

    private ArrayList<MenuOption> setUpOptions(){
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


}
