package com.twu.biblioteca.support;

import java.io.IOException;

public class Messages {

    private static final int MAXLENGTHLINE = 50;

    public static void printWelcomeMessage() {
        printCharacterLine('#');
        printStringinMiddleSorroundedWith('#',"Biblioteca");
        printCharacterLine('~');
        printStringinMiddleSorroundedWith('#',"Nihil Sciemus Sed Est Exiguus");
        printCharacterLine('#');
        printStringinMiddleSorroundedWith('#', "May you be greeted");
        printCharacterLine('#');
        System.out.print("\n");
    }

    private static void printCharacterLine(char c){
        for (int i = 0; i < MAXLENGTHLINE; i++) {
            System.out.print(c);
        }
        System.out.print("\n");
    }


    private static void printStringinMiddleSorroundedWith(char c,String something){
        System.out.print(c);
        for (int i = 0; i < MAXLENGTHLINE-2; i++) {
            System.out.print(" ");
            if(i == ((MAXLENGTHLINE/2)-(something.length()/2))){
                System.out.print(something);
                i+=something.length();
            }
        }
        System.out.print(c);
        System.out.print("\n");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
