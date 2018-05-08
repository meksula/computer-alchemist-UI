package com.computeralchemist.consoleUI.exception;

/**
 * @Author
 * Karol Meksuła
 * 08-05-2018
 * */

public class FormNotCompleteException extends RuntimeException {

    @Override
    public String getMessage() {
        return "One or more field in form is empty.";
    }
}
