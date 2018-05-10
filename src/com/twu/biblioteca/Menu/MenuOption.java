package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Library;

public interface MenuOption {

    String getOptionContent();

    String getCommand();

    String displayRessources(Library Library);

}
