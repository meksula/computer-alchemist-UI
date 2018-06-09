package com.computeralchemist.desktop.logic.jersey;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class DefaultAuthentication implements AuthenticationApi {
    private static DefaultAuthentication defaultAuthentication = new DefaultAuthentication();
    private ClientConfig clientConfig;

    protected DefaultAuthentication() {}

    public static DefaultAuthentication getInstance() {
        return DefaultAuthentication.defaultAuthentication;
    }

    @Override
    public int login(String username, String password) {
        return executeRequest(username, password);
    }

    @Override
    public ClientConfig getCurrentClientConfig() {
        return clientConfig;
    }

    private ClientConfig buildConfiguration(String username, String password) {
        ClientConfig clientConfig = new ClientConfig();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(username, password);
        clientConfig.register(feature);
        clientConfig.register(JacksonFeature.class);
        return clientConfig;
    }

    private int executeRequest(String username, String password) {
        clientConfig = buildConfiguration(username, password);

        Client client = ClientBuilder.newClient(clientConfig);
        WebTarget webTarget = client.target("http://51.38.129.50:8080/login");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder
                .cookie("param1","value1")
                .cookie(new Cookie("param2", "value2"))
                .get();

        return response.getStatus();
    }

}
