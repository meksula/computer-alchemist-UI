package com.computeralchemist.consoleUI.mapping;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import com.computeralchemist.consoleUI.components.cpu.Cpu;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public class ComponentJsonMapper implements JsonMapper {
    private ObjectMapperSimpleFactory factory;
    private String json;
    String type;

    public ComponentJsonMapper() {
        factory = new ObjectMapperSimpleFactory();
    }

    @Override
    public ComputerComponent parseJson(String json) throws IOException {
        this.json = json;
        type = extractComponentType();

        return factory.mapByType(json, type);
    }

    private String extractComponentType() {
        String REGEX = "Type\" : \"[a-z]{3,}\"";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(json);
        String extracted = "";
        if (matcher.find()) {
            extracted = matcher.group();
            return extracted.substring(9, extracted.length() - 1);
        }

        return extracted;
    }

}
