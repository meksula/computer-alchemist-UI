package com.computeralchemist.consoleUI.mapping;

import com.computeralchemist.consoleUI.components.ComputerComponent;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public interface JsonMapper {
    ComputerComponent parseJson(String json) throws ClassNotFoundException, IOException;
}
