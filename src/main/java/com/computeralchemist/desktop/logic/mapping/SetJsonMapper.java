package com.computeralchemist.desktop.logic.mapping;

import com.computeralchemist.desktop.dto.set.ComputerSet;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 19-05-2018
 * */

public class SetJsonMapper {

    public ComputerSet parseJson(String jsonResult) throws IOException {
        return new ObjectMapperSimpleFactory().mapToComputerSet(jsonResult, extractType(jsonResult));
    }

    private String extractType(String jsonResult) {
        String REGEX = "type\" : \"[a-z]{3,}\"";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(jsonResult);
        String extracted = "";
        if (matcher.find()) {
            extracted = matcher.group();
            return extracted.substring(9, extracted.length() - 1);
        }

        return extracted;

    }
}
