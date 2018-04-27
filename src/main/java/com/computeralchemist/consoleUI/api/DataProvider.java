package com.computeralchemist.consoleUI.api;

import com.computeralchemist.consoleUI.components.ComputerComponent;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public interface DataProvider {
    ComputerComponent getComponent() throws IOException, ClassNotFoundException;
}
