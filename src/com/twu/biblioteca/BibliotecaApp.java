package com.twu.biblioteca;

import com.twu.biblioteca.Menu.ListBookOption;
import com.twu.biblioteca.Menu.Main;
import com.twu.biblioteca.Menu.MenuOption;
import com.twu.biblioteca.Menu.QuietOption;
import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Messages;

import java.awt.*;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp Biblioteca = new BibliotecaApp();
        Biblioteca.run();
    }

    private void run(){
        Library Library = new Library();
        Messages.printWelcomeMessage();
        Main Main = new Main(setUpOptionList(Library));
        Main.run();

    }


    private ArrayList<MenuOption> setUpOptionList(Library Library){
        ArrayList<MenuOption> Options = new ArrayList<>();
        ListBookOption LBO = new ListBookOption(Library);
        QuietOption QO = new QuietOption();
        Options.add(LBO); Options.add(QO);
        return Options;
    }




}
