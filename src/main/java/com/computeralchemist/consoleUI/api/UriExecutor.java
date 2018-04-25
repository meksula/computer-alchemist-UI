package com.computeralchemist.consoleUI.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public class UriExecutor {
    private String uri;

    public UriExecutor(String uri) {
        this.uri = uri;
    }

    public void execute() {
        Client client = Client.create();

        WebResource webResource = client.resource(uri);

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientResponse.class);

        String json = response.getEntity(String.class);if (response.getStatus() != 200) {
            System.out.println("Nie powiodło się.");
        }

        System.out.println(json);
    }
}
