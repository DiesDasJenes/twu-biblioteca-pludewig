package com.twu.biblioteca;

import com.twu.biblioteca.menu.Menu;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Messages;
import com.twu.biblioteca.support.Setup;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp Biblioteca = new BibliotecaApp();
        Biblioteca.run();
    }

    private void run(){
        Messages.printWelcomeMessage();
        Menu MainMenu = setUpMenu();
        while(true) {
            MainMenu.execute();
        }
    }

    private Menu setUpMenu()
    {
        Setup setup = new Setup();
        Library library = new Library();
        return new Menu(setup.setUpOptions(library),setup.setUpLibraryandFakeData(library));
    }





}
