package com.computeralchemist.consoleUI.api;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public class UriCreator {
    private StringBuilder builder;

    private UriCreator() {
        builder = new StringBuilder();
    }

    private static UriCreator uriCreator = new UriCreator();

    public static UriCreator getUriCreator() {
        return uriCreator;
    }

    private final String localhost = "http://localhost:8080";

    public String prepareUri(String path, String type, String id) {
        return StringUriBuilder.getStringUriBuilder()
                .append(localhost)
                .slash()
                .append(path)
                .slash()
                .append(type)
                .slash()
                .append(id)
                .build();
    }
}
