package com.computeralchemist.consoleUI.api;

import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 27-04-2018
 * */

public class UriExecutorTest {
    private UriExecutor uriExecutor;
    private final String uri = "http://localhost:8080/components/cpu/2/";

    @Before
    public void setUp() {
        uriExecutor = new UriExecutor();
    }

    @Test
    public void executeMethodTest() throws MalformedURLException {
        uriExecutor.setAbsolutePath(uri);
        String string = uriExecutor.execute();
        assertNotNull(string);
    }

    @Test
    public void isAbsoluteTest() {
        boolean condition = URI.create(uri).isAbsolute();
        assertTrue(condition);
    }

    @Test
    public void isAbsoluteTest2() {
        String path = uri.concat("/opinion");
        boolean condition = URI.create(path).isAbsolute();
        assertTrue(condition);
    }
}