package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.set.ComputerSet;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class ComputerSetRequestsCommand extends RequestCommand<ComputerSet> {

    @Override
    protected ComputerSet mapToObject(String jsonResult) {
        return null;
    }

    @Override
    protected String createUri(List<String> uriParts) {
        return null;
    }
}
