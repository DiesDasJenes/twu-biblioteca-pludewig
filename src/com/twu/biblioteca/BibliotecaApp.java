package com.twu.biblioteca;

import com.twu.biblioteca.SubMenu.Login;
import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Messages;
import com.twu.biblioteca.support.MockModel_Customer;
import sun.security.tools.keytool.Main;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library Library = new Library();
        Messages.printWelcomeMessage();
        com.twu.biblioteca.Menu.Main.initiate();

    }


}
