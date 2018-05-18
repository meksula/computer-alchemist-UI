package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.logic.jersey.ApiConnector;
import com.computeralchemist.desktop.logic.jersey.GetApiConnector;
import com.computeralchemist.desktop.logic.mapping.ComponentJsonMapper;
import com.computeralchemist.desktop.logic.mapping.JsonMapper;
import com.computeralchemist.desktop.logic.uri.DefaultUriBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class ComponentRequestsCommand<ComputerComponent> extends RequestCommand<ComputerComponent> {
    private ApiConnector apiConnector;
    private JsonMapper jsonMapper;

    public ComponentRequestsCommand() {
        this.apiConnector = new GetApiConnector();
        this.jsonMapper = new ComponentJsonMapper();
    }

    @Override
    protected ComputerComponent mapToObject(String jsonResult) throws IOException, ClassNotFoundException {
         return (ComputerComponent) jsonMapper.parseJson(jsonResult);
    }

    @Override
    protected String createUri(List<String> uriParts) {
        return new DefaultUriBuilder().buildUri(uriParts);
    }

    protected String executeGetUri(String uri) {
        return apiConnector.executeGetRequest(uri);
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
