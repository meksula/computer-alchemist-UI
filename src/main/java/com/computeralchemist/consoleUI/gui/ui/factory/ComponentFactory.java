package com.computeralchemist.consoleUI.gui.ui.factory;

import com.computeralchemist.consoleUI.components.ComputerComponent;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 08-05-2018
 * */

public abstract class ComponentFactory {
    public abstract ComputerComponent createComponent(Map<String, String> properties);

    public enum FactoryType {
        CPU {
            @Override
            public ComponentFactory chooseFactory() {
                return new CpuFactory();
            }
        },

        MOTHERBOARD {
            @Override
            public ComponentFactory chooseFactory() {
                return null;
            }
        },

        DISK {
            @Override
            public ComponentFactory chooseFactory() {
                return null;
            }
        },

        RAM {
            @Override
            public ComponentFactory chooseFactory() {
                return null;
            }
        },

        GPU {
            @Override
            public ComponentFactory chooseFactory() {
                return null;
            }
        },

        SUPPLY {
            @Override
            public ComponentFactory chooseFactory() {
                return null;
            }
        },

        COMPUTERCASE {
            @Override
            public ComponentFactory chooseFactory() {
                return null;
            }
        };

        public abstract ComponentFactory chooseFactory();
    }
}
