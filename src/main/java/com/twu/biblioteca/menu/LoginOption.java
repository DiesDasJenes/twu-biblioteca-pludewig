package com.twu.biblioteca.menu;

import com.twu.biblioteca.support.Querist;
import com.twu.biblioteca.support.Customer;
import com.twu.biblioteca.support.Messages;
import com.twu.biblioteca.support.MockModel_Customer;

public class LoginOption {
    MockModel_Customer MockModel_Customer;
    public LoginOption(MockModel_Customer MockModel_Customer){
        this.MockModel_Customer = MockModel_Customer;
    }

    private void loginUser(){
        System.out.println("Please Login with your Credentials");
        if(checkCredentials(MockModel_Customer,askForLoginName(),askForPassword())){
                // For Release 2
            }else{
                Messages.clearConsole();
                Messages.printWelcomeMessage();
                System.out.println("LoginName or Password wrong.");
                System.out.println("Please try again.");
                this.loginUser();
            }
    }

    private String askForLoginName(){
        Querist q = new Querist(System.in,System.out);
        return q.ask("Please Enter your LoginName").toString();
    }

    private String askForPassword(){
        Querist q = new Querist(System.in,System.out);
        return q.ask("Please Enter your Password").toString();
    }

    private boolean checkCredentials(MockModel_Customer MM_C, String LoginName,String Password){
        for (Customer c: MM_C.getListofCustomers().values()) {
            if(c.getLoginName().equals(LoginName)){
                if(c.getPasswordHash() == Password.hashCode()){
                    return true;
                }
            }
        }
        return false;
    }
}
