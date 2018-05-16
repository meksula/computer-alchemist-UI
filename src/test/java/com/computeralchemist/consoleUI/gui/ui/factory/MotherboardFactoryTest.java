package com.computeralchemist.consoleUI.gui.ui.factory;

import com.computeralchemist.consoleUI.components.motherboard.Motherboard;
import com.computeralchemist.consoleUI.components.motherboard.MotherboardParameters;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 09-05-2018
 * */

public class MotherboardFactoryTest {
    private MotherboardFactory motherboardFactory;
    private Map<String, String> properties;
    private Motherboard motherboard;
    private MotherboardParameters parameters;

    private final String PRODUCENT = "producent";
    private final String MODEL = "logic";
    private final String DESCRIPTION = "description";
    private final String TYPE = "type";
    private final String CHIPSET = "chipset";
    private final String SOCKET = "socket";
    private final String RAM_SOCKETS = "ramSockets";
    private final String BIOS = "bios";
    private final String MEMORY_TYPE = "memoryType";
    private final String MEMORY_FREQUENCY = "memoryFrequency";
    private final String PROCESORS_AVAILABLE = "procesorAvailables";
    private final String OTHER_SOCKETS = "otherSockets";

    private final String PRODUCENT_VALUE = "Gigabyte";
    private final String MODEL_VALUE = "sdvere";
    private final String DESCRIPTION_VALUE = "Jakaś tam zwykła płyta główna...";
    private final String TYPE_VALUE = "ATX";
    private final String CHIPSET_VALUE = "z653";
    private final String SOCKET_VALUE = "socket 1151";
    private final String RAM_SOCKETS_VALUE = "4";
    private final String BIOS_VALUE = "bios super bios";
    private final String MEMORY_TYPE_VALUE = "DDR4";
    private final String MEMORY_FREQUENCY_VALUE = "5423";
    private final String PROCESORS_AVAILABLE_VALUE = "core i4, core i5, core i6";
    private final String OTHER_SOCKETS_VALUE = "socket1, socket2, socket3";

    @Before
    public void setUp() {
        properties = new LinkedHashMap<>();
        properties.put(PRODUCENT, PRODUCENT_VALUE);
        properties.put(MODEL, MODEL_VALUE);
        properties.put(DESCRIPTION, DESCRIPTION_VALUE);
        properties.put(TYPE, TYPE_VALUE);
        properties.put(CHIPSET, CHIPSET_VALUE);
        properties.put(SOCKET, SOCKET_VALUE);
        properties.put(RAM_SOCKETS, RAM_SOCKETS_VALUE);
        properties.put(BIOS, BIOS_VALUE);
        properties.put(MEMORY_TYPE, MEMORY_TYPE_VALUE);
        properties.put(MEMORY_FREQUENCY, MEMORY_FREQUENCY_VALUE);
        properties.put(PROCESORS_AVAILABLE, PROCESORS_AVAILABLE_VALUE);
        properties.put(OTHER_SOCKETS, OTHER_SOCKETS_VALUE);

        motherboardFactory = new MotherboardFactory();
        motherboard = (Motherboard) motherboardFactory.createComponent(properties);
        parameters = motherboard.getMotherboardParameters();
    }

    @Test
    public void basicValuesTest() {
        assertEquals(PRODUCENT_VALUE, motherboard.getProducent());
        assertEquals(MODEL_VALUE, motherboard.getModel());
        assertEquals(DESCRIPTION_VALUE, motherboard.getDescription());

    }

    @Test
    public void parameterTest() {
        assertEquals(TYPE_VALUE, parameters.getType());
        assertEquals(CHIPSET_VALUE, parameters.getChipset());
        assertEquals(SOCKET_VALUE, parameters.getSocket());
        assertEquals(Integer.parseInt(RAM_SOCKETS_VALUE), parameters.getRamSockets());
        assertEquals(BIOS_VALUE, parameters.getBios());
        assertEquals(MEMORY_TYPE_VALUE, parameters.getMemoryType());
        assertEquals(Double.parseDouble(MEMORY_FREQUENCY_VALUE), parameters.getMemoryFrequency(), 1e-15);
        assertEquals(3, parameters.getProcesorAvailables().size());
        assertEquals(3, parameters.getOtherSockets().size());
    }
}