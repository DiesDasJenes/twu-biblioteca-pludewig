package com.twu.biblioteca.menu.option;

import com.twu.biblioteca.menu.suboption.SubMenuOption;

public class CheckInResource extends OptionWithSubOption {
    public CheckInResource(SubMenuOption... subMenuOptions){
        super("What would you like to (r)eturn: (B)ook or (M)ovie?",subMenuOptions);
    }
}
