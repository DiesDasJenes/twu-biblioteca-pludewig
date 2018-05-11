package com.twu.biblioteca;

import com.twu.biblioteca.Menu.*;
import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Messages;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp Biblioteca = new BibliotecaApp();
        Biblioteca.run();
    }

    private void run(){
        Messages.printWelcomeMessage();
        Menu MainMenu = setUpMainMenu();
        while(true){
            MainMenu.executeMenu();
        }
    }

    private Menu setUpMainMenu() {
        Library Libary = new Library();
        ListallBookOption LBO = new ListallBookOption();
        QuitOption QO = new QuitOption();
        ListOneBookOption LOBO = new ListOneBookOption();
        CheckOutOption COO = new CheckOutOption();
        CheckInOption CIO = new CheckInOption();
        ArrayList<MenuOption> Options= new ArrayList<>();
        Options.add(LBO);  Options.add(LOBO);
        Options.add(COO); Options.add(CIO);
        Options.add(QO);
        return new Menu(Options,Libary);
    }


}
