package com.computeralchemist.desktop.logic.jersey;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @Author
 * Karol Meksuła
 * 09-06-2018
 * */

public class DefaultRegistrationApi implements RegistrationApi {
    private static DefaultRegistrationApi defaultRegistrationApi = new DefaultRegistrationApi();

    private DefaultRegistrationApi() {}

    public static DefaultRegistrationApi getDefaultRegistrationApi() {
        return defaultRegistrationApi;
    }

    @Override
    public String registerUser(RegistrationForm registrationForm) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://51.38.129.50:8080/api/v1/registration");
        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.post(Entity.entity(parseObjectToString(registrationForm), MediaType.APPLICATION_JSON));

        return String.valueOf(response.getStatus());
    }

    private String parseObjectToString(RegistrationForm registrationForm) {
        String json = "";
        try {
            json = new ObjectMapper().writeValueAsString(registrationForm);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}
