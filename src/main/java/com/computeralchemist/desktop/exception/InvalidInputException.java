package com.computeralchemist.desktop.exception;

/**
 * @Author
 * Karol Meksuła
 * 08-05-2018
 * */

public class InvalidInputException extends RuntimeException {
    private String field;

    public InvalidInputException(String field) {
        this.field = field;
    }

    @Override
    public String getMessage() {
        return "In field '" + field + "' Number expected.";
    }
}
