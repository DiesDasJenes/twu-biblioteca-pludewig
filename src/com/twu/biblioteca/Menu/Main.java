package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Messages;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.Optional;

public class Main {
    ArrayList<MenuOption> Options;
     public Main(ArrayList<MenuOption> options){
         this.Options = options;
     }


    public void run(){
        printOptions();
        askForOption();
    }

    private void askForOption(){
        Querist Querist = new Querist(System.in,System.out);
        while(true){
            String answer = Querist.ask("Please choose an Option").toString().trim();
            for (MenuOption option:Options
                 ) {
                if (option.getCommand().equals(answer)){
                    Messages.clearConsole();
                    option.executeCommand();
                }
            }
        }
    }

    private void printOptions(){
        int count = 1;
         for (MenuOption option:Options
             ) {
             System.out.println(count++ + ". " + option.getCommandContent());
        }
     }

}
