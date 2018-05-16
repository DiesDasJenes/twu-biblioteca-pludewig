package com.twu.biblioteca.support;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Querist {
    private final Scanner scanner;
    private final PrintStream out;

    public Querist(InputStream in, PrintStream out){
        scanner = new Scanner(in);
        this.out = out;
    }

    public String ask(String message){
        out.println(message);
        out.print("*");
        return scanner.next().toUpperCase().trim();
    }

}
