package com.computeralchemist.consoleUI.api;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public class ComponentUriCreator implements UriCreator {
    private ComponentUriCreator() {}

    private static ComponentUriCreator uriCreator = new ComponentUriCreator();

    public static ComponentUriCreator getUriCreator() {
        return uriCreator;
    }

    private final String localhost = "http://localhost:8080/components/";

    public String prepareUri(List<String> elements) {
        StringUriBuilder builder = StringUriBuilder.getStringUriBuilder();
        builder.append(localhost);

        for (int i = 0; i < elements.size(); i++) {
            StringUriBuilder.getStringUriBuilder()
                    .append(elements.get(i)).slash();
        }

        return builder.build();
    }

    public static class StringUriBuilder {
        private StringBuilder stringBuilder;

        private StringUriBuilder() {
            this.stringBuilder = new StringBuilder();
        }

        private static StringUriBuilder stringUriBuilder = new StringUriBuilder();

        static StringUriBuilder getStringUriBuilder() {
            return stringUriBuilder;
        }

        StringUriBuilder append(String string) {
            stringBuilder.append(string);
            return stringUriBuilder;
        }

        StringUriBuilder slash() {
            stringBuilder.append("/");
            return stringUriBuilder;
        }

        String build() {
            String result = this.stringBuilder.toString();
            stringBuilder = new StringBuilder();
            return result;
        }
    }
}
