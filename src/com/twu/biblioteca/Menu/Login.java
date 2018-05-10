package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Querist;
import com.twu.biblioteca.support.Customer;
import com.twu.biblioteca.support.Messages;
import com.twu.biblioteca.support.MockModel_Customer;
// Only using this for simulation, never for work
public class Login {

    public Login(){}

    public boolean askandcheckCredentials(MockModel_Customer MockModel_Customer){
        System.out.println("Please enter your Login Credentials");
        while(true){
            if(checkCredentials(MockModel_Customer,askForLoginName(),askForPassword())){
                return true;
            }else{
                Messages.clearConsole();
                Messages.printWelcomeMessage();
                System.out.println("LoginName or Password wrong.");
                System.out.println("Please try again.");
            }
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
