package com.computeralchemist.consoleUI.mapping;

import com.computeralchemist.consoleUI.components.cpu.Cpu;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public class ComponentJsonMapperTest {
    private String json = "{\n" +
            "  \"componentType\" : \"cpu\",\n" +
            "  \"producent\" : \"AMD\",\n" +
            "  \"model\" : \"Ryzen 5 1600\",\n" +
            "  \"description\" : \"AMD Ryzen 5 1600 wprowadza na rynek nową jakość. Wszystko za sprawą usprawnienia procesu technologicznego 14 nm, przyspieszenia pamięci podręcznej (zwłaszcza na poziomie L2 i L3) oraz zwiększenia parametru IPC, odpowiedzialnego za realizację operacji w ramach jednego cyklu zegara. Dzięki temu praca Twojego komputera stanie się znacznie sprawniejsza niż do tej pory.\",\n" +
            "  \"urlToResource\" : null,\n" +
            "  \"compatibleIndex\" : 7.0,\n" +
            "  \"votes\" : 0,\n" +
            "  \"allPoints\" : 0.0,\n" +
            "  \"ratesEvg\" : 0.0,\n" +
            "  \"cpuParameters\" : {\n" +
            "    \"cores\" : 6,\n" +
            "    \"series\" : \"Ryzen 5\",\n" +
            "    \"socket\" : \"AM4\",\n" +
            "    \"threads\" : 12,\n" +
            "    \"bitArchitecture\" : \"64bit\",\n" +
            "    \"cache\" : 16,\n" +
            "    \"frequency\" : 3.2,\n" +
            "    \"content\" : [ ],\n" +
            "    \"links\" : [ ]\n" +
            "  },\n" +
            "  \"links\" : [ {\n" +
            "    \"rel\" : \"self\",\n" +
            "    \"href\" : \"http://localhost:8080/components/cpu/1\",\n" +
            "    \"hreflang\" : null,\n" +
            "    \"media\" : null,\n" +
            "    \"title\" : null,\n" +
            "    \"type\" : null,\n" +
            "    \"deprecation\" : null,\n" +
            "    \"content\" : [ ],\n" +
            "    \"links\" : [ ]\n" +
            "  } ]\n" +
            "}";

    private ComponentJsonMapper componentJsonMapper;
    private final String EXPECTED_TYPE = "cpu";

    @Before
    public void setUp() throws IOException {
        this.componentJsonMapper = new ComponentJsonMapper();
        componentJsonMapper.parseJson(json);
    }

    @Test
    public void parseJsonTest() throws IOException {
        Cpu component = (Cpu) componentJsonMapper.parseJson(json);
        assertNotNull(component);
        assertEquals("cpu", component.getComponentType());
        assertEquals("AMD", component.getProducent());
        assertEquals(0, component.getVotes());
        assertEquals("AM4", component.getCpuParameters().getSocket());
    }

    @Test
    public void extractComponentTypeShouldWorkCorrectly() {
        String type = componentJsonMapper.extractComponentType();
        assertEquals(EXPECTED_TYPE, type);
    }
}