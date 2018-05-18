package com.computeralchemist.desktop.exception;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public class CannotReadTypeException extends RuntimeException {
    private String type;

    public CannotReadTypeException(String type) {
        this.type = type;
    }

    @Override
    public String getMessage() {
        return "Cannot parse JSON. There is no type like [" + type + "]";
    }
}
