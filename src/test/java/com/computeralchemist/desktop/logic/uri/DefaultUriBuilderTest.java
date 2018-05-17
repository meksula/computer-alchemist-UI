package com.computeralchemist.desktop.logic.uri;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class DefaultUriBuilderTest {
    private DefaultUriBuilder defaultUriBuilder;
    private final String EXPECTED_URI = "http://localhost:8080/v1/components/motherboard/default/43/";

    @Before
    public void setUp() {
        defaultUriBuilder = new DefaultUriBuilder();
    }

    @Test
    public void uriBuildingTest() {
        String uri = defaultUriBuilder.buildUri(getFakeList());
        assertEquals(uri, EXPECTED_URI);
    }

    private List<String> getFakeList() {
        return new ArrayList<>(Arrays.asList("v1", "components", "motherboard", "default", "43"));
    }
}