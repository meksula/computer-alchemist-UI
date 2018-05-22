package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.motherboard.Motherboard;
import com.computeralchemist.desktop.exception.FormNotCompleteException;
import com.computeralchemist.desktop.exception.InvalidInputException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class MotherboardCreatorTest {
    private static MotherboardCreator motherboardCreator;
    private static Map<String, String> properties;

    private static final String VALUE0 = "Opis płyty";
    private static final String VALUE1 = "Gigabyte";
    private static final String VALUE2 = "idjid";
    private static final String VALUE3 = "ddc";
    private static final String VALUE4 = "131dc";
    private static final String VALUE5 = "dcvf";
    private static final String VALUE6 = "3";
    private static final String VALUE7 = "rc4f";
    private static final String VALUE8 = "DDR4";
    private static final String VALUE9 = "34556";
    private static final String VALUE10 = "i3;i5;i7";
    private static final String VALUE11 = "eef;eec;xewq;exw;";

    @BeforeClass
    public static void setUp() {
        properties = new LinkedHashMap<>();
        properties.put("value0", VALUE0);
        properties.put("value1", VALUE1);
        properties.put("value2", VALUE2);
        properties.put("value3", VALUE3);
        properties.put("value4", VALUE4);
        properties.put("value5", VALUE5);
        properties.put("value6", VALUE6);
        properties.put("value7", VALUE7);
        properties.put("value8", VALUE8);
        properties.put("value9", VALUE9);
        properties.put("value10", VALUE10);
        properties.put("value11", VALUE11);

        motherboardCreator = new MotherboardCreator(properties);
    }

    @Test
    public void initPropertiesTest() {
        Motherboard motherboard = (Motherboard) motherboardCreator.buildComponent();

        assertEquals(3, motherboard.getMotherboardParameters().getProcesorAvailables().size());
        assertEquals(4, motherboard.getMotherboardParameters().getOtherSockets().size());
    }

}