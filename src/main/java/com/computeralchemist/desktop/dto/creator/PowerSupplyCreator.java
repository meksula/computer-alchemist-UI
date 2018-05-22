package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.supply.PowerSupply;
import com.computeralchemist.desktop.dto.components.supply.PowerSupplyParameters;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class PowerSupplyCreator extends ComponentCreator {
    private PowerSupply powerSupply;
    private PowerSupplyParameters parameters;

    public PowerSupplyCreator(Map<String, String> properties) {
        super(properties);

        this.powerSupply = new PowerSupply();
        this.parameters = new PowerSupplyParameters();
        this.powerSupply.setPowerSupplyParameters(parameters);
        this.powerSupply.setComponentType("supply");
    }

    @Override
    protected ComputerComponent buildComponent() {
        powerSupply.setDescription(extractString(VALUE0));
        powerSupply.setProducent(extractString(VALUE1));
        powerSupply.setModel(extractString(VALUE2));

        parameters.setStandard(extractString(VALUE3));
        parameters.setPower((int) numberParse(VALUE4, "power"));
        parameters.setPfc(extractString(VALUE5));
        parameters.setCooler(extractString(VALUE6));
        parameters.setModularCable(ComponentFactory.modular);
        parameters.setConnectors(convertToList(VALUE7));

        return powerSupply;
    }
    
}














