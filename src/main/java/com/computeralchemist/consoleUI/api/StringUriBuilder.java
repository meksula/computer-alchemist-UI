package com.computeralchemist.consoleUI.api;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public class StringUriBuilder {
    private StringBuilder stringBuilder;

    private StringUriBuilder() {
        this.stringBuilder = new StringBuilder();
    }

    private static StringUriBuilder stringUriBuilder = new StringUriBuilder();

    public static StringUriBuilder getStringUriBuilder() {
        return stringUriBuilder;
    }

    public StringUriBuilder append(String string) {
        stringBuilder.append(string);
        return stringUriBuilder;
    }

    public StringUriBuilder slash() {
        stringBuilder.append("/");
        return stringUriBuilder;
    }

    public String build() {
        String result = this.stringBuilder.toString();
        stringBuilder = new StringBuilder();
        return result;
    }
}
