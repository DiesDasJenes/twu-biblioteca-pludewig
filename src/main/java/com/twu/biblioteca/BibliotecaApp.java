package com.twu.biblioteca;

import com.twu.biblioteca.menu.Menu;
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
            MainMenu.executeMenu();
        }
    }

    private Menu setUpMenu()
    {
        Setup setup = new Setup();
        return new Menu(setup.setUpSubOptions(),setup.setUpOptions(),setup.setUpLibrary());
    }





}
