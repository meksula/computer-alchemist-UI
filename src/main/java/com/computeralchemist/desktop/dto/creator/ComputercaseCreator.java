package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.computerCase.ComputerCase;
import com.computeralchemist.desktop.dto.components.computerCase.ComputerCaseParameters;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class ComputercaseCreator extends ComponentCreator {
    private ComputerCase computerCase;
    private ComputerCaseParameters parameters;

    public ComputercaseCreator(Map<String, String> properties) {
        super(properties);

        this.computerCase = new ComputerCase();
        this.parameters = new ComputerCaseParameters();
        computerCase.setComputerCaseParameters(parameters);
        computerCase.setComponentType("computercase");
    }

    @Override
    protected ComputerComponent buildComponent() {
        computerCase.setDescription(extractString(VALUE0));
        computerCase.setProducent(extractString(VALUE1));
        computerCase.setModel(extractString(VALUE2));

        parameters.setType(extractString(VALUE3));
        parameters.setHeight(numberParse(VALUE4, "height"));
        parameters.setWidth(numberParse(VALUE5, "width"));
        parameters.setWeight(numberParse(VALUE6, "weight"));
        parameters.setCompatibilityMotherboards(convertToList(VALUE7));
        parameters.setConnectors(convertToList(VALUE8));

        return computerCase;
    }
}
