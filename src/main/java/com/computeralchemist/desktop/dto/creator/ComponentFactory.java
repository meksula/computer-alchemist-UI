package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public enum ComponentFactory {

    cpu {
        @Override
        public ComputerComponent buildComponent(Map<String, String> properties) {
            return new CpuCreator(properties).buildComponent();
        }
    },

    motherboard {
        @Override
        public ComputerComponent buildComponent(Map<String, String> properties) {
            return new MotherboardCreator(properties).buildComponent();
        }
    },

    ram {
        @Override
        public ComputerComponent buildComponent(Map<String, String> properties) {
            return new RamCreator(properties).buildComponent();
        }
    },

    disk {
        @Override
        public ComputerComponent buildComponent(Map<String, String> properties) {
            return new DiskCreator(properties).buildComponent();
        }
    },

    gpu {
        @Override
        public ComputerComponent buildComponent(Map<String, String> properties) {
            return new GpuCreator(properties).buildComponent();
        }
    },

    computercase {
        @Override
        public ComputerComponent buildComponent(Map<String, String> properties) {
            return new ComputercaseCreator(properties).buildComponent();
        }
    },

    supply {


        @Override
        public ComputerComponent buildComponent(Map<String, String> properties) {
            return new PowerSupplyCreator(properties).buildComponent();
        }
    };

    public static boolean modular;

    public abstract ComputerComponent buildComponent(Map<String, String> properties);

}
