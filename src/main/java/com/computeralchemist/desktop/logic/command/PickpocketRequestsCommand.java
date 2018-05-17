package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.components.ComputerComponent;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class PickpocketRequestsCommand extends RequestCommand<ComputerComponent> {

    @Override
    protected ComputerComponent mapToObject(String jsonResult) {
        return null;
    }

    @Override
    protected String createUri(List<String> uriParts) {
        return null;
    }

    /*
    * Module Pickpocket is able only to post `link` and have to return computer component
    * */

    @Override
    protected String executePostUri(String uri) {
        //TODO
        return super.executePostUri(uri);
    }
}
