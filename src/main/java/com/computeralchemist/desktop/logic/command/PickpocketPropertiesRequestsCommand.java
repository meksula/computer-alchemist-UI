package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.logic.jersey.PostApiConnector;
import com.computeralchemist.desktop.logic.jersey.pickpocket.PickpocketApi;
import com.computeralchemist.desktop.logic.jersey.pickpocket.PickpocketApiConnector;
import com.computeralchemist.desktop.logic.jersey.pickpocket.PickpocketLink;
import com.computeralchemist.desktop.logic.uri.DefaultUriBuilder;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class PickpocketPropertiesRequestsCommand {
    private PickpocketApi pickpocketApi;
    private PickpocketLink pickpocketLink;

    public PickpocketPropertiesRequestsCommand(PickpocketLink link) {
        this.pickpocketLink = link;
        this.pickpocketApi = new PickpocketApiConnector();
    }

    public List<String> executeRequest(List<String> uriParts) throws IOException {
        String uri = createUri(uriParts);
        String result = executePostUri(uri);

        return mapToObject(result);
    }

    protected List<String> mapToObject(String jsonResult) throws IOException {
        return new ObjectMapper().readValue(jsonResult, new TypeReference<List<String>>(){});
    }

    protected String createUri(List<String> uriParts) {
        return new DefaultUriBuilder().buildUri(uriParts);
    }

    /*
    * Module Pickpocket is able only to post `link` and have to return computer component
    * */

    protected String executePostUri(String uri) {
         return pickpocketApi.executeRequest(uri, pickpocketLink);
    }
}
