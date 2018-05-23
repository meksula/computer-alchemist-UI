package com.computeralchemist.desktop.logic.jersey.pickpocket;

import com.computeralchemist.desktop.logic.jersey.DefaultAuthentication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @Author
 * Karol Meksuła
 * 23-05-2018
 * */

public class PickpocketApiConnector implements PickpocketApi {
    private ClientConfig clientConfig;

    public PickpocketApiConnector() {
        this.clientConfig = DefaultAuthentication.getInstance().getCurrentClientConfig();
    }

    @Override
    public String executeRequest(String uriToExecute, PickpocketLink pickpocketLink) {
        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget webTarget = client.target(uriToExecute);

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(convertToJson(pickpocketLink), MediaType.APPLICATION_JSON));

        return response.readEntity(String.class);
    }

    String convertToJson(PickpocketLink link) {
        String result = "";
        try {
            result = new ObjectMapper().writeValueAsString(link);
        } catch (JsonProcessingException e) {
            e.getMessage();
        }

        return result;
    }

}
