package com.twu.biblioteca;

import com.twu.biblioteca.SubMenu.Login;
import com.twu.biblioteca.support.Messages;
import com.twu.biblioteca.support.MockModel_Customer;

public class BibliotecaApp {

    public static void main(String[] args) {
        Messages.printWelcomeMessage();
        Login LoginMenu = new Login();
        MockModel_Customer MM_C = new MockModel_Customer();
        LoginMenu.askandcheckCredentials(MM_C);

    }


}
