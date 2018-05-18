package com.computeralchemist.desktop.logic.jersey;

import org.glassfish.jersey.client.ClientConfig;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public interface AuthenticationApi {
    int login(String username, String password);

    ClientConfig getCurrentClientConfig();
}
