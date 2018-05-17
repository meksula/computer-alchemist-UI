package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.components.ComputerComponent;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class ComponentRequestsCommand extends RequestCommand<ComputerComponent> {
    @Override
    protected ComputerComponent mapToObject(String jsonResult) {
        return null;
    }

    @Override
    protected String createUri(List<String> uriParts) {
        return null;
    }

    protected String executeGetUri(String uri) {
        return null;
    }

    protected String executePostUri(String uri) {
        return null;
    }

    protected String executePutUri(String uri) {
        return null;
    }

    protected boolean executeDeleteUri(String uri) {
        return false;
    }
}
