package com.twu.biblioteca.support;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MessagesTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Test
    public void clearConsole() {
        System.out.println("##########################################\n##########################################\n##########################################");
        Messages.clearConsole();
        assertEquals("",systemOutRule.getLog());
    }

    @Test
    public void canGetCharacterLine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //TODO Add Argument #
        Method method = Messages.class.getDeclaredMethod("printCharacterLine");
        method.setAccessible(true);
        assertEquals("##########################################",method.invoke("#"));
    }

    @Test
    public void canGetStringinMiddleSorroundedWith() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //TODO Add Argument Text
        Method method = Messages.class.getDeclaredMethod("printStringinMiddleSorroundedWith");
        method.setAccessible(true);
        assertEquals("#                     Biblioteca                 #",method.invoke("Biblioteca","#"));

    }

    @Test
    public void printWelcomeMessage() {
        Messages.printWelcomeMessage();

        assertEquals("##########################################\n#\t\t\t\tBiblioteca\t\t\t\t#\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n#\t\tNihil Sciemus Sed Est Exiguus\t#\n##########################################\n\t\t\t   May you be greeted",systemOutRule.getLog().substring(0,305));
    }
}