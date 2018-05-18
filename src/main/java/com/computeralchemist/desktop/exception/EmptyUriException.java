package com.computeralchemist.desktop.exception;

/**
 * @Author
 * Karol Meksuła
 * 30-04-2018
 * */

public class EmptyUriException extends RuntimeException {

    @Override
    public String getMessage() {
        return "URI to execute POST request is not setted yet!";
    }
}
