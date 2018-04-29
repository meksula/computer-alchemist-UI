package com.computeralchemist.consoleUI.api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public class UriExecutor implements UriExecute {
    private String absolutePath;
    private String result;

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    @Override
    public String execute() {

        try {
            Client client = Client.create();
            WebResource webResource = client.resource(absolutePath);
            ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
            if (clientResponse.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + clientResponse.getStatus());
            }

            result = clientResponse.getEntity(String.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
