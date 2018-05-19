package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.logic.jersey.ApiConnector;
import com.computeralchemist.desktop.logic.jersey.GetApiConnector;
import com.computeralchemist.desktop.logic.mapping.ComponentJsonMapper;
import com.computeralchemist.desktop.logic.mapping.JsonMapper;
import com.computeralchemist.desktop.logic.uri.DefaultUriBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 19-05-2018
 * */

public class ComponentListRequestCommand extends RequestCommand<List<ComputerComponent>> {
    private ApiConnector apiConnector;
    private JsonMapper jsonMapper;
    private String listType;

    public ComponentListRequestCommand() {
        this.apiConnector = new GetApiConnector();
        this.jsonMapper = new ComponentJsonMapper();
    }

    @Override
    protected List<ComputerComponent> mapToObject(String jsonResult) throws IOException, ClassNotFoundException {
        return jsonMapper.listOfComponents(jsonResult, listType);
    }

    @Override
    protected String createUri(List<String> uriParts) {
        this.listType = uriParts.get(uriParts.size() - 1);
        return new DefaultUriBuilder().buildUri(uriParts);
    }

    protected String executeGetUri(String uri) {
        return apiConnector.executeGetRequest(uri);
    }

    protected boolean executeDeleteUri(String uri) {
        return false;
    }
}
