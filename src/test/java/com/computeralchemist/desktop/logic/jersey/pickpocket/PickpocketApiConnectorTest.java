package com.computeralchemist.desktop.logic.jersey.pickpocket;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class PickpocketApiConnectorTest {
    private PickpocketApiConnector connector = new PickpocketApiConnector();

    @Test
    public void jsonShouldHasCorrectFormat() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PickpocketLink link = new PickpocketLink("http://localhost:8080/cacmsck/aca");

        connector.convertToJson(link);
    }
}