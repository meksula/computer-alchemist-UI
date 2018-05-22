package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.logic.jersey.PostApiConnector;
import com.computeralchemist.desktop.logic.uri.DefaultUriBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class ComponentPostRequestCommand extends RequestCommand<ComputerComponent> {
    private ComputerComponent computerComponent;

    public ComponentPostRequestCommand(ComputerComponent computerComponent) {
        this.computerComponent = computerComponent;
    }

    @Override
    protected ComputerComponent mapToObject(String jsonResult) throws IOException, ClassNotFoundException {
        return null;
    }

    @Override
    protected String createUri(List<String> uriParts) {
        return new DefaultUriBuilder().buildUri(uriParts);
    }

    protected String executePostUri(String uri) {
        return new PostApiConnector().postComponent(uri, computerComponent);
    }

}