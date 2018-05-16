package com.twu.biblioteca.menu;

import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CheckOutResource extends MenuOption {
    CheckOutResource(SubMenuOption... subMenuOptions){
        super("What would you like to (b)orrow: (B)ook or (M)ovie", subMenuOptions);
    }

}
