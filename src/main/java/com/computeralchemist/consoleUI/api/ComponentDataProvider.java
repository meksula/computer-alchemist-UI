package com.computeralchemist.consoleUI.api;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import com.computeralchemist.consoleUI.mapping.ComponentJsonMapper;
import com.computeralchemist.consoleUI.mapping.JsonMapper;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public class ComponentDataProvider implements DataProvider {
    private JsonMapper jsonMapper;
    private UriCreator uriCreator;
    private UriExecute uriExecute;

    private List<String> pathElements;
    private String requestUri;
    private String json;

    public ComponentDataProvider(List<String> pathElements) {
        this.pathElements = pathElements;
        this.jsonMapper = new ComponentJsonMapper();
        this.uriCreator = ComponentUriCreator.getUriCreator();
        this.uriExecute = new UriExecutor();
    }

    @Override
    public ComputerComponent getComponent() throws IOException, ClassNotFoundException {
        this.requestUri = uriCreator.prepareUri(pathElements);
        uriExecute.setAbsolutePath(requestUri);
        json = uriExecute.execute();
        return jsonMapper.parseJson(json);
    }
}
