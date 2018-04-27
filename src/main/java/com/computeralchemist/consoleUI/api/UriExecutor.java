package com.computeralchemist.consoleUI.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.net.URI;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public class UriExecutor implements UriExecute {

    @Override
    public String execute(String path) {
        Client client = Client.create();
        WebResource webResource = client.resource(URI.create(path));

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        return response.getEntity(String.class);
    }
}
