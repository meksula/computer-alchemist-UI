package com.computeralchemist.desktop.logic.mapping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 19-05-2018
 * */

public abstract class AbstractJsonMapper {

    public static String extractComponentType(String json) {
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
