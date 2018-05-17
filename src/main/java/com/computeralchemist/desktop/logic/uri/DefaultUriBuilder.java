package com.computeralchemist.desktop.logic.uri;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class DefaultUriBuilder implements UriBuilder {
    private final String DEFAULT_ELEMENT = "http://localhost:8080/";

    @Override
    public String buildUri(List<String> uriParts) {
        StringBuilder builder = new StringBuilder();
        builder.append(DEFAULT_ELEMENT);

        uriParts.forEach(element -> {
            builder.append(element).append("/");
        });

        return builder.toString();
    }
}
