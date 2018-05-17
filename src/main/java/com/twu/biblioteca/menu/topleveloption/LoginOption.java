package com.twu.biblioteca.menu.topleveloption;

import com.twu.biblioteca.menu.Option;
import com.twu.biblioteca.resources.Library;
import com.twu.biblioteca.support.Querist;

public class LoginOption implements Option {

    private String askForLoginName() {
        Querist q = new Querist(System.in, System.out);
        return q.ask("Please Enter your Library number");
    }

    private String askForPassword() {
        Querist q = new Querist(System.in, System.out);
        return q.ask("Please Enter your Password");
    }


    boolean checkCredentials(Library library, String loginName, String password) {
        return library.getListOfAllCustomer().containsKey(loginName) && (password.hashCode() == library.getListOfAllCustomer().get(loginName).getPasswordHash());
    }

    @Override
    public String getContent() {
        return "(S)ign Up";
    }

    @Override
    public String getKey() {
        return "S";
    }

    @Override
    public String execute(Library library) {
        System.out.println("Please Login with your Credentials");
        String LoginName = askForLoginName();
        String password = askForPassword();
        if (checkCredentials(library, LoginName, password)) {
            library.setCurrentCustomer(library.getListOfAllCustomer().get(LoginName));
            return "Sign Up succeeded.";
        } else {
            System.out.println("LoginName or Password wrong.");
            return "Please try again.";
        }
    }

}
