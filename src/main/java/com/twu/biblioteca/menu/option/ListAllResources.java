package com.twu.biblioteca.menu.option;

import com.twu.biblioteca.menu.suboption.SubMenuOption;

public class ListAllResources extends OptionWithSubOption {
    public ListAllResources(SubMenuOption... subMenuOptions){
        super("What would you like to be (l)isted: (B)ook or (M)ovie",subMenuOptions);
    }
}
