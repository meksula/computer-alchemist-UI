package com.computeralchemist.consoleUI.controller;

import com.computeralchemist.consoleUI.components.ComputerComponent;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @Author
 * Karol Meksuła
 * 30-04-2018
 * */

public interface PostCommand {

    void getObject(ComputerComponent computerComponent);

    String mapObjectToJson();

    MultivaluedMap<String, String> executePost();

}
