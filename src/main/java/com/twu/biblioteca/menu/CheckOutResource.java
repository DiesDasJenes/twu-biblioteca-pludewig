package com.twu.biblioteca.menu;

import com.twu.biblioteca.menu.submenu.SubMenuOption;

public class CheckOutResource extends MenuOption {
    CheckOutResource(SubMenuOption... subMenuOptions){
        super("What would you like to (b)orrow: (B)ook or (M)ovie", subMenuOptions);
    }

}
