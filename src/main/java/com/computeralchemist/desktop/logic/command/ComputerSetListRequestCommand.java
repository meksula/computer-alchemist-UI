package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.set.ComputerSet;
import com.computeralchemist.desktop.logic.jersey.GetApiConnector;
import com.computeralchemist.desktop.logic.mapping.ObjectMapperSimpleFactory;
import com.computeralchemist.desktop.logic.uri.DefaultUriBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 19-05-2018
 * */

public class ComputerSetListRequestCommand extends RequestCommand<List<ComputerSet>> {
    private String type;

    @Override
    protected List<ComputerSet> mapToObject(String jsonResult) throws IOException, ClassNotFoundException {
        return new ObjectMapperSimpleFactory().mapToSetList(jsonResult, type);
    }

    @Override
    protected String createUri(List<String> uriParts) {
        this.type = uriParts.get(1);
        return new DefaultUriBuilder().buildUri(uriParts);
    }

    @Override
    protected String executeGetUri(String uri) {
        return new GetApiConnector().executeGetRequest(uri);
    }

}
