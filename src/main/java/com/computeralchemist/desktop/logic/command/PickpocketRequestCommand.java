package com.computeralchemist.desktop.logic.command;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.logic.jersey.DefaultAuthentication;
import com.computeralchemist.desktop.logic.jersey.pickpocket.PickpocketApiConnector;
import com.computeralchemist.desktop.logic.jersey.pickpocket.PickpocketLink;
import com.computeralchemist.desktop.logic.mapping.AbstractJsonMapper;
import com.computeralchemist.desktop.logic.mapping.ObjectMapperSimpleFactory;
import com.computeralchemist.desktop.logic.uri.DefaultUriBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 23-05-2018
 * */

public class PickpocketRequestCommand extends RequestCommand<ComputerComponent> {
    private PickpocketLink pickpocketLink;

    public PickpocketRequestCommand(PickpocketLink pickpocketLink) {
        this.pickpocketLink = pickpocketLink;
    }

    @Override
    protected ComputerComponent mapToObject(String jsonResult) throws IOException, ClassNotFoundException {
        return new ObjectMapperSimpleFactory().mapByType(jsonResult, AbstractJsonMapper.extractComponentType(jsonResult));
    }

    @Override
    protected String createUri(List<String> uriParts) {
        return new DefaultUriBuilder().buildUri(uriParts);
    }

    protected String executePostUri(String uri) {
        return new PickpocketApiConnector().executeRequest(uri, pickpocketLink);
    }

}
