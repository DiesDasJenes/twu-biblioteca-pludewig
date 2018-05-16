package com.twu.biblioteca.menu.option;

import com.twu.biblioteca.menu.suboption.SubMenuOption;

public class CheckOutResource extends OptionWithSubOption {
    public CheckOutResource(SubMenuOption... subMenuOptions){
        super("What would you like to (b)orrow: (B)ook or (M)ovie", subMenuOptions);
    }

}
