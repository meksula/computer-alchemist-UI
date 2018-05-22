package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.exception.FormNotCompleteException;
import com.computeralchemist.desktop.exception.InvalidInputException;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class CpuCreatorTest {
    private CpuCreator cpuCreator;
    Map<String, String> properties = new LinkedHashMap<>();

    private final String PRODUCENT = "Intel";
    private final String MODEL = "i7";
    private final String DESCRIPTION = "To jest bardzo fajny procek.";
    private final String SOCKET = "1151 Coffee lake";
    private final String CORES = "4";
    private final String SERIES = "intel core 8th gen";
    private final String THREADS = "4";
    private final String BIT = "64bit";
    private final String CACHE = "12";
    private final String FREQUENCY = "23423";

    @Before
    public void setUp() {
        properties.put("value0", DESCRIPTION);
        properties.put("value1", PRODUCENT);
        properties.put("value2", MODEL);
        properties.put("value3", CORES);
        properties.put("value5", SOCKET);

        cpuCreator = new CpuCreator(properties);
    }

    @Test(expected = FormNotCompleteException.class)
    public void notCompletedFormTest() {
        cpuCreator.buildComponent();
    }

    @Test(expected = InvalidInputException.class)
    public void cannotParse_notContainNumberTest() {
        properties.put("value4", SERIES);
        properties.put("value6", THREADS);
        properties.put("value7", BIT);
        properties.put("value8", CACHE);
        properties.put("value9", "invalid");

        cpuCreator.buildComponent();
    }

    @Test
    public void shouldCorrectlyCreateComponent() {
        properties.put("value4", SERIES);
        properties.put("value6", THREADS);
        properties.put("value7", BIT);
        properties.put("value8", CACHE);
        properties.put("value9", FREQUENCY);

        Cpu computerComponent = (Cpu) cpuCreator.buildComponent();

        assertNotNull(computerComponent);
        assertEquals(THREADS, String.valueOf(computerComponent.getCpuParameters().getThreads()));
    }

}