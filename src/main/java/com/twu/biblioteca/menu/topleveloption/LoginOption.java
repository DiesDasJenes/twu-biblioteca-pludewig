package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Customer;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;
import com.twu.biblioteca.support.Messages;

public class LoginOption implements Option {


    private void loginUser(Library library) {
        System.out.println("Please Login with your Credentials");

        if(checkCredentials(library,askForLoginName(),askForPassword())){
                // For Release 2
            }else{
                Messages.clearConsole();
                Messages.printWelcomeMessage();
                System.out.println("LoginName or Password wrong.");
                System.out.println("Please try again.");
                this.loginUser(library);
            }

    }

    private String askForLoginName() {
        Querist q = new Querist(System.in, System.out);
        return q.ask("Please Enter your LoginName").toString();
    }

    private String askForPassword() {
        Querist q = new Querist(System.in, System.out);
        return q.ask("Please Enter your Password").toString();
    }


    private boolean checkCredentials(Library library, String LoginName, String Password){
        for (Customer c: library.getListOfAllCustomer().values()) {
            if(c.getLoginName().equals(LoginName)){
                if(c.getPasswordHash() == Password.hashCode()){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getContent() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String execute(Library library) {
        return null;
    }

}
