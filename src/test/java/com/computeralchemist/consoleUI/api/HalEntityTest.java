package com.computeralchemist.consoleUI.api;

import com.computeralchemist.consoleUI.components.cpu.Cpu;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HalEntityTest {
    private final String JSON = "{\n" +
            "  \"componentType\" : \"cpu\",\n" +
            "  \"producent\" : \"AMD\",\n" +
            "  \"logic\" : \"Ryzen 5 1600\",\n" +
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
            "    \"integratedGpu\" : null,\n" +
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
            "  }, {\n" +
            "    \"rel\" : \"collection\",\n" +
            "    \"href\" : \"http://localhost:8080/components/cpu\",\n" +
            "    \"hreflang\" : null,\n" +
            "    \"media\" : null,\n" +
            "    \"title\" : null,\n" +
            "    \"type\" : null,\n" +
            "    \"deprecation\" : null,\n" +
            "    \"content\" : [ ],\n" +
            "    \"links\" : [ ]\n" +
            "  } ]\n" +
            "}";

    @Test
    public void convertJsonTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        /*mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);*/
        Cpu cpu = mapper.readValue(JSON, Cpu.class);

        assertNotNull(cpu);

        assertEquals("AMD", cpu.getProducent());
        assertEquals(2, cpu.getLinks().size());
    }
}
