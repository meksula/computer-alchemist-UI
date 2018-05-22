package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.exception.FormNotCompleteException;
import com.computeralchemist.desktop.exception.InvalidInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public abstract class ComponentCreator {
    final String VALUE0 = "value0";
    final String VALUE1 = "value1";
    final String VALUE2 = "value2";
    final String VALUE3 = "value3";
    final String VALUE4 = "value4";
    final String VALUE5 = "value5";
    final String VALUE6 = "value6";
    final String VALUE7 = "value7";
    final String VALUE8 = "value8";
    final String VALUE9 = "value9";
    final String VALUE10 = "value10";
    final String VALUE11 = "value11";
    final String VALUE12 = "value12";
    final String VALUE13 = "value13";

    protected Map<String, String> properties;

    public ComponentCreator(Map<String, String> properties) {
        this.properties = properties;
    }

    protected abstract ComputerComponent buildComponent();

    protected List<String> splitProperty(String property) {
        String[] splited = property.split(";");
        return Arrays.asList(splited);
    }

    protected double numberParse(String mapPlace, String fieldname) {
        double value;
        try {
            value = Double.parseDouble(properties.get(mapPlace));
        } catch (NumberFormatException nfe) {
            throw new InvalidInputException(fieldname);
        }

        return value;
    }

    protected String extractString(String mapPlace) {
        String param = properties.get(mapPlace);

        if (param == null || param.isEmpty())
            throw new FormNotCompleteException();

        return param;
    }

    protected List<String> convertToList(String mapPlace) {
        String param = properties.get(mapPlace);

        if (param == null || param.isEmpty())
            throw new FormNotCompleteException();

        List<String> list = splitProperty(param);

        if (list == null || list.size() == 0)
            throw new FormNotCompleteException();

        return list;
    }

}
