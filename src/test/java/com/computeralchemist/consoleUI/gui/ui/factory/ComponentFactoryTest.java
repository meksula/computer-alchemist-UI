package com.computeralchemist.consoleUI.gui.ui.factory;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 08-05-2018
 * */

public class ComponentFactoryTest {

    @Test
    public void instantiateFactoryMethodTest() {
        ComponentFactory factory = ComponentFactory.FactoryType.CPU.chooseFactory();
        assertNotNull(factory);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInstantiateShouldThrowException() {
        ComponentFactory.FactoryType.valueOf("dfv").chooseFactory();
    }
}