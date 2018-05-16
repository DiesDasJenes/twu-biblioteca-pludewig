package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.submenu.SubMenuOption;

public class ListAllResources extends MenuOption {
    ListAllResources(SubMenuOption... subMenuOptions){
        super("What would you like to be (l)isted: (B)ook or (M)ovie",subMenuOptions);
    }
}
