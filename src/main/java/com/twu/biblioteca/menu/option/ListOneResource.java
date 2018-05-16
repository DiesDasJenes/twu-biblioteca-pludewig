package com.twu.biblioteca.menu.option;

import com.twu.biblioteca.menu.suboption.SubMenuOption;

public class ListOneResource extends OptionWithSubOption {
    public ListOneResource(SubMenuOption... subMenuOptionsList) {
        super("What would you like to be showed in (d)etail? (B)ook or (M)ovie", subMenuOptionsList);
    }
}
