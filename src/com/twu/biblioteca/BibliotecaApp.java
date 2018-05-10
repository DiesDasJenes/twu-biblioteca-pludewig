package com.twu.biblioteca;

import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Messages;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp Biblioteca = new BibliotecaApp();
    }

    private void run(){
        Messages.printWelcomeMessage();
        Library Library = new Library();


    }


}
