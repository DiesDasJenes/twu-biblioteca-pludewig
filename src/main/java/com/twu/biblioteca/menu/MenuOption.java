package com.twu.biblioteca.menu;

import java.util.ArrayList;

public interface MenuOption {

    String getCommandContent();

    ArrayList<String> getCommand();

    SubMenuOption executeCommand(String input);

    void processOption();

}
