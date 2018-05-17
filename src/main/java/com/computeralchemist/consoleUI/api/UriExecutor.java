package com.computeralchemist.consoleUI.api;


import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public class UriExecutor implements UriExecute {
    private String absolutePath;
    private String username = "karoladmin";
    private String password = "karoladmin";
    private int httpStatus;

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    @Override
    public String execute() {
        return "";
    }

    private ClientConfig clientConfig;
    private Client client;
    private HttpAuthenticationFeature feature;
    private Response response;

    private Cookie cookie;

    public MultivaluedMap<String, Object> executeSecured() {
        clientConfig = new ClientConfig();

        feature = HttpAuthenticationFeature.basic(username, password);
        clientConfig.register(feature);

        clientConfig.register(JacksonFeature.class);

        client = ClientBuilder.newClient(clientConfig);
        WebTarget webTarget = client.target("http://localhost:8080/components/cpu/2");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        response = invocationBuilder
                .cookie("param1","value1")
                .cookie(cookie = new Cookie("param2", "value2"))
                .get();

        int httpStatus = response.getStatus();


        return response.getHeaders();
    }

    public String executeSecondStep() {
        WebTarget webTarget = client.target("http://localhost:8080/components/ram/1");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        int httpStatus = response.getStatus();
        System.out.println(httpStatus);

        return response.readEntity(String.class);
    }

    public void presentCookies() {
        response.getCookies().forEach((k,v) -> {
            System.out.println("Cookie KEY: " + k);
            System.out.println("Cookie VALUE: " + v);
        });
    }

    public String tryConnectWithCookie() {
        WebTarget webTarget = client.target("http://localhost:8080/components/motherboard/1");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        int httpStatus = response.getStatus();

        System.out.println(httpStatus);

        return response.readEntity(String.class);
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String tryReallyNewRequest() {
        WebTarget webTarget = client.target("http://localhost:8080/components/disk/1");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        return response.readEntity(String.class);
    }
}
