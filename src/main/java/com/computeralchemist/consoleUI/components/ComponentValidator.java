package com.computeralchemist.consoleUI.components;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 07-05-2018
 * */

public class ComponentValidator {
    private static ComponentValidator componentValidator;

    private ComponentValidator() {}

    public static ComponentValidator getComponentValidator() {
        return componentValidator;
    }

    public boolean validateData(Map<String,String> properties) {
        return true;
    }
}
