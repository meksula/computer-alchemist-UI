package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.set.ComputerSet;
import com.computeralchemist.desktop.logic.jersey.GetApiConnector;
import com.computeralchemist.desktop.logic.mapping.SetJsonMapper;
import com.computeralchemist.desktop.logic.uri.DefaultUriBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class ComputerSetRequestsCommand extends RequestCommand<ComputerSet> {

    @Override
    protected ComputerSet mapToObject(String jsonResult) throws IOException {
        return new SetJsonMapper().parseJson(jsonResult);
    }

    @Override
    protected String createUri(List<String> uriParts) {
        return new DefaultUriBuilder().buildUri(uriParts);
    }

    @Override
    protected String executeGetUri(String uri) {
        return new GetApiConnector().executeGetRequest(uri);
    }

}
