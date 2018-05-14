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
    public void canGetCharacterLine() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Messages.printCharacterLine('#');
        assertEquals("##################################################\n",systemOutRule.getLog());
    }

    @Test
    public void canGetStringinMiddleSorroundedWith() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Messages.printStringinMiddleSorroundedWith('#',"Biblioteca");
        assertEquals("#                     Biblioteca                 #\n",systemOutRule.getLog());

    }

    @Test
    public void printWelcomeMessage() {
        Messages.printWelcomeMessage();

        assertEquals("##################################################\n#                     Biblioteca                 #\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n#            Nihil Sciemus Sed Est Exiguus       #\n##################################################\n#                 May you be greeted             #\n##################################################",systemOutRule.getLog().substring(0,356));
    }
}