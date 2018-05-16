package com.twu.biblioteca.menu.option;

import com.twu.biblioteca.menu.suboption.SubMenuOption;
import com.twu.biblioteca.support.Querist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OptionWithSubOption {
    private Map<String,SubMenuOption> subMenuOptions;
    private String commandContent;

    OptionWithSubOption(String content, SubMenuOption... subMenuOptionsList){
        subMenuOptions = new HashMap<>();
        for (SubMenuOption option: subMenuOptionsList
             ) {
            subMenuOptions.put(option.getCommand(),option);
        }
        this.commandContent = content;
    }

    public String getCommandContent() {
        return commandContent;
    }

    public ArrayList<String> getSubMenuCommands() {
        ArrayList<String> commandList = new ArrayList<>();
        subMenuOptions.forEach((key,subM) -> commandList.add(subM.getCommand()));
        return commandList;
    }

    public SubMenuOption getSubMenu(String input) {
        return subMenuOptions.get(input);
    }

    public void processOption() {
        Querist querist = new Querist(System.in,System.out);
        getSubMenu(querist.ask(this.getCommandContent()).toString().trim());
    }

}
