package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Messages;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main extends Menu{

    public Main(ArrayList<MenuOption> options, Menu parent, ArrayList<Menu> subMenus, String name){
         super(options,parent,subMenus,name);
         System.out.println(super.getName());
     }

}
