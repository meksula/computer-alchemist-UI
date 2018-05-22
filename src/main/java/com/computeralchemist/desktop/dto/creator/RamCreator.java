package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.ram.Ram;
import com.computeralchemist.desktop.dto.components.ram.RamParameters;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class RamCreator extends ComponentCreator {
    private Ram ram;
    private RamParameters parameters;

    public RamCreator(Map<String, String> properties) {
        super(properties);

        this.ram = new Ram();
        parameters = new RamParameters();
        ram.setRamParameters(parameters);
        ram.setComponentType("ram");
    }

    @Override
    protected ComputerComponent buildComponent() {
        ram.setDescription(extractString(VALUE0));
        ram.setProducent(extractString(VALUE1));
        ram.setModel(extractString(VALUE2));

        parameters.setMemoryType(extractString(VALUE3));
        parameters.setCooler(extractString(VALUE4));
        parameters.setModules((int) numberParse(VALUE5, "modules"));
        parameters.setCapacityGb((int) numberParse(VALUE6, "capacity"));
        parameters.setFrequency(numberParse(VALUE7, "frequency"));
        parameters.setSocketType(extractString(VALUE8));

        return ram;
    }
}
