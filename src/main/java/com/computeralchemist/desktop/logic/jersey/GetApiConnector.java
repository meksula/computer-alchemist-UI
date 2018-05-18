package com.computeralchemist.desktop.logic.jersey;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class GetApiConnector implements ApiConnector {
    private ClientConfig clientConfig;

    public GetApiConnector() {
        clientConfig = DefaultAuthentication.getInstance().getCurrentClientConfig();
    }

    @Override
    public String executeGetRequest(String uri) {
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget webTarget = client.target(uri);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        return response.readEntity(String.class);
    }



}
