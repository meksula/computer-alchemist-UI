package com.computeralchemist.jersey.trial;

import com.computeralchemist.consoleUI.api.UriExecutor;

import javax.ws.rs.core.MultivaluedMap;

public class Login {

    public static void main(String[]args) {
        UriExecutor uriExecutor = new UriExecutor();

       /* MultivaluedMap<String, Object> result = uriExecutor.executeSecured();

        result.forEach((k,v) -> {
            System.out.println(k + ", " + v);
        });

        System.out.println("------------------");

        uriExecutor.executeSecondStep();

        System.out.println("-------------------------");

        uriExecutor.presentCookies();

        System.out.println("---------------------------------");

        String result2 = uriExecutor.tryConnectWithCookie();
        System.out.println(result2);*/

       String result = uriExecutor.tryReallyNewRequest();

        System.out.println(result);
    }

}
