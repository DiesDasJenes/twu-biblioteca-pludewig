package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.submenu.SubMenuOption;

public class ListOneResource extends MenuOption {
    public ListOneResource(SubMenuOption... subMenuOptionsList) {
        super("What would you like to be showed in (d)etail? (B)ook or (M)ovie", subMenuOptionsList);
    }
}
