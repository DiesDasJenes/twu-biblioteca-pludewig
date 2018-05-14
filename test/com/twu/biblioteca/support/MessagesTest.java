package com.twu.biblioteca.support;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MessagesTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock = TextFromStandardInputStream.emptyStandardInputStream();

    @Test
    @Ignore
    public void clearConsole() {
        System.out.println("##########################################\n##########################################\n##########################################");
        Messages.clearConsole();
        assertEquals("",systemOutRule.getLog());
    }

    @Test
    @Ignore
    public void canGetCharacterLine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Class cls = Class.forName("com.twu.biblioteca.support.Messages");
        Object obj = cls.newInstance();
        Class[] paramChar = new Class[1];
        paramChar[0] = char.class;
        Method method = cls.getDeclaredMethod("printCharacterLine",paramChar);
        method.setAccessible(true);
        assertEquals("##########################################",method.invoke(obj,'#'));
    }

    @Test
    @Ignore
    public void canGetStringinMiddleSorroundedWith() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //TODO Add Argument Text
        Method method = Messages.class.getDeclaredMethod("printStringinMiddleSorroundedWith");
        method.setAccessible(true);
        assertEquals("#                     Biblioteca                 #",method.invoke("Biblioteca","#"));

    }

    @Test
    public void printWelcomeMessage() {
        Messages.printWelcomeMessage();

        assertEquals("##################################################\n#                     Biblioteca                 #\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n#            Nihil Sciemus Sed Est Exiguus       #\n##################################################\n#                 May you be greeted             #\n##################################################",systemOutRule.getLog().substring(0,356));
    }
}