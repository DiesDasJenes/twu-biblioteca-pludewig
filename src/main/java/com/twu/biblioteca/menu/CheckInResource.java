package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.submenu.SubMenuOption;

public class CheckInResource extends MenuOption {
    CheckInResource(SubMenuOption... subMenuOptions){
        super("What would you like to (r)eturn: (B)ook or (M)ovie?",subMenuOptions);
    }
}
