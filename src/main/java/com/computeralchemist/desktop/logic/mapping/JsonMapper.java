package com.computeralchemist.desktop.logic.mapping;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public interface JsonMapper {
    ComputerComponent parseJson(String json) throws ClassNotFoundException, IOException;

    String componentJson(ComputerComponent computerComponent) throws JsonProcessingException;

    List<ComputerComponent> listOfComponents(String json, String type) throws IOException;
}
