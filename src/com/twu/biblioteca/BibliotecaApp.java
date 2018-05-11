package com.twu.biblioteca;

import com.twu.biblioteca.Menu.*;
import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Messages;
import com.twu.biblioteca.support.MockModel_Customer;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp Biblioteca = new BibliotecaApp();
        Biblioteca.run();
    }

    private void run(){
        Menu Parent = setUpMenuStructure();
        Messages.printWelcomeMessage();
        Parent.executeMenu();
    }




    private Menu setUpMenuStructure(){
        Library Library = new Library();
        ArrayList<MenuOption> LoginOption = new ArrayList<>();
        MockModel_Customer MMC = new MockModel_Customer();
        LoginOption LO = new LoginOption(MMC);
        LoginOption.add(LO);
        Menu Login = new Menu(LoginOption, null, ArrayList<Menu> subMenus, "Login Menu");
        return Parent;
    }

    private Menu setUpMenuBookList(){

    }

    private Menu setUpMenuMain(Library Library,Menu parent){
        ArrayList<Menu> subMenus = new ArrayList<>();
        subMenus.add(setUpMenuBookList());
        Menu Main = new Menu(setUpOptionStructureForMain(Library),parent,subMenus,"Main Menu");

    }

    private ArrayList<MenuOption> setUpOptionStructureForMain(Library Library){
        ArrayList<MenuOption> Options = new ArrayList<>();
        ListBookOption LBO = new ListBookOption(Library);
        QuitOption QO = new QuitOption();
        Options.add(LBO); Options.add(QO);
        return Options;
    }



}
