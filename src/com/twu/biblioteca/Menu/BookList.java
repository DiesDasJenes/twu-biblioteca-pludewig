package com.twu.biblioteca.Menu;

import java.util.ArrayList;

public class BookList extends Menu {

    private static final String MENU_NAME = "List of all Books";

    public BookList(ArrayList<MenuOption> options,Menu parent,ArrayList<Menu> subMenus,String name) {
        super(options,parent,subMenus,MENU_NAME);
        System.out.println(MENU_NAME);
    }
}
