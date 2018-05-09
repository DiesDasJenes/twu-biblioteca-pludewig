package com.twu.biblioteca.SubMenu;

import com.twu.biblioteca.Querist;

public class Login {



    void askforCredentials(){
        System.out.println("Please enter your Login Credentials");
    }

    void askForLoginName(){
        Querist q = new Querist(System.in,System.out);
        while(true){
            q.ask("Please Enter your LoginName");
        }

    }
}
