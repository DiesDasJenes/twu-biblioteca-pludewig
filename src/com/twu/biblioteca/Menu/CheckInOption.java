package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Library;
import com.twu.biblioteca.support.Querist;

public class CheckInOption implements MenuOption {

    @Override
    public String getCommandContent() {
        return "(R)eturn a Book";
    }

    @Override
    public String getCommand() {
        return "R";
    }

    @Override
    public void executeCommand(Library Library) {
        Querist querist = new Querist(System.in,System.out);
        String answer = querist.ask("Please enter the Id of the book you want to see the details of.").toString().trim();
        if(Library.getListOfAllBooks().containsKey(Integer.parseInt(answer)) && !Library.getListOfAllBooks().get(Integer.parseInt(answer)).isCheckedIn()){
            Library.getListOfAllBooks().get(Integer.parseInt(answer)).invertCheckedFlag();
            System.out.println("Thank you for returning the book.");
        }else{
            System.out.println("That is not a valid book to return.");
        }
    }


}
