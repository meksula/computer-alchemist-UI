package com.computeralchemist.consoleUI.gui.ui.factory;

import com.computeralchemist.consoleUI.components.cpu.Cpu;
import com.computeralchemist.consoleUI.components.cpu.CpuParameters;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 08-05-2018
 * */

public class CpuFactoryTest {
    private CpuFactory cpuFactory;
    private final Map<String, String> properties = new LinkedHashMap<>();

    private final String PRODUCENT = "Intel";
    private final String MODEL = "core i7";
    private final String DESCRIPTION = "procesor najnowszej generacji";
    private final int CORES = 8;
    private final String SERIES = "Intel Core 8th gen.";
    private final String SOCKET = "socket 1151";
    private final int THREADS = 12;
    private final String BIT_ARCH = "64bit";
    private final int CACHE = 14;
    private final double FREQUENCY = 4242;

    private Cpu cpu;
    private CpuParameters parameters;

    @Before
    public void setUp() {
        properties.put("producent", PRODUCENT);
        properties.put("model", MODEL);
        properties.put("description", DESCRIPTION);
        properties.put("cores", String.valueOf(CORES));
        properties.put("series", SERIES);
        properties.put("socket", SOCKET);
        properties.put("threads", String.valueOf(THREADS));
        properties.put("bitArchitecture", BIT_ARCH);
        properties.put("cache", String.valueOf(CACHE));
        properties.put("frequency", String.valueOf(FREQUENCY));

        cpuFactory = new CpuFactory();
        cpuFactory.createComponent(properties);

        cpu = (Cpu) cpuFactory.getComputerComponent();
        parameters = cpu.getCpuParameters();
    }

    @Test
    public void initializeTest() {
        assertNotNull(cpuFactory);
    }

    @Test
    public void propertiesSetTest() {
        assertEquals(PRODUCENT, cpu.getProducent());
        assertEquals(MODEL, cpu.getModel());
        assertEquals(DESCRIPTION, cpu.getDescription());
    }

    @Test
    public void setCoresTest() {
        assertEquals(CORES, parameters.getCores());
    }

    @Test
    public void setSeriesTest() {
        assertEquals(SERIES, parameters.getSeries());
    }

    @Test
    public void setSocketTest() {
        assertEquals(SOCKET, parameters.getSocket());
    }

    @Test
    public void setThreadsTest() {
        assertEquals(THREADS, parameters.getThreads());
    }

    @Test
    public void setBitArchitectureTest() {
        assertEquals(BIT_ARCH, parameters.getBitArchitecture());
    }

    @Test
    public void setCacheTest() {
        assertEquals(CACHE, parameters.getCache());
    }

    @Test
    public void setFrequencyTest() {
        assertEquals(FREQUENCY, parameters.getFrequency(), 1e-15);
    }

}