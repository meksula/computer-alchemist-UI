package com.computeralchemist.consoleUI.api.post;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.consoleUI.exception.EmptyUriException;
import com.computeralchemist.consoleUI.mapping.ComponentJsonMapper;
import com.computeralchemist.consoleUI.mapping.JsonMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import lombok.Getter;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @Author
 * Karol Meksuła
 * 30-04-2018
 * */

@Getter
public class PostComputerComponent implements PostObject {
    private Client client;
    private JsonMapper jsonMapper;

    private String uri;
    private ComputerComponent computerComponent;
    private MultivaluedMap<String, String> header;
    private String result;

    public PostComputerComponent() {
        client = Client.create();
        jsonMapper = new ComponentJsonMapper();
    }

    @Override
    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public void setObject(Object object) {
        this.computerComponent = (ComputerComponent) object;
    }

    private String parseObject() throws JsonProcessingException {
        return jsonMapper.componentJson(computerComponent);
    }

    @Override
    public MultivaluedMap<String, String> executePostRequest() {

        if (uri == null)
            throw new EmptyUriException();

        try {
            WebResource webResource = client.resource(uri);

            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, parseObject());

            if (response.getStatus() != 201)
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

            result = response.getEntity(String.class);
            header = response.getHeaders();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return header;
    }

}
