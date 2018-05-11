package com.twu.biblioteca.Menu;

import com.twu.biblioteca.support.Messages;

public class ReturnToParentOption implements MenuOption {
    Menu Parent;
    ReturnToParentOption(Menu parent){
        this.Parent = parent;
    }

    @Override
    public String getCommandContent() {
        return "(R)eturn to " + Parent.getName();
    }

    @Override
    public String getCommand() {
        return "R";
    }

    @Override
    public void executeCommand() {
        Messages.clearConsole();
        this.Parent.executeMenu();
    }
}
