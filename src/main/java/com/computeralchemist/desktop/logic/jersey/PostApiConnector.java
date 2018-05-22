package com.computeralchemist.desktop.logic.jersey;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class PostApiConnector implements PostApi {
    private String uri;
    private ComputerComponent computerComponent;
    private ClientConfig clientConfig;

    public PostApiConnector() {
        clientConfig = DefaultAuthentication.getInstance().getCurrentClientConfig();
    }

    @Override
    public String postComponent(String uri, ComputerComponent computerComponent) {
        this.uri = uri;
        this.computerComponent = computerComponent;

        return String.valueOf(execute());
    }

    private int execute() {
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget webTarget = client.target(uri);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(parseObjectToString(), MediaType.APPLICATION_JSON));

        return response.getStatus();
    }

    private String parseObjectToString() {
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(computerComponent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}
