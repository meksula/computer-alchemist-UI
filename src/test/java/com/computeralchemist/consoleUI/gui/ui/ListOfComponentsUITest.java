package com.computeralchemist.consoleUI.gui.ui;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 09-05-2018
 * */

public class ListOfComponentsUITest {

    private final String text = "1. AMD, Ryzen 5 2445f, RATES: 0.0";

    @Test
    public void regexTest() {
        Pattern pattern = Pattern.compile(",\\s[.],");
        Matcher matcher = pattern.matcher(text);
        boolean isFind = matcher.find();
        assertTrue(isFind);
    }
}