package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.gpu.GraphicsCard;
import com.computeralchemist.desktop.dto.components.gpu.GraphicsCardParameters;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class GpuCreator extends ComponentCreator {
    private GraphicsCard graphicsCard;
    private GraphicsCardParameters parameters;

    public GpuCreator(Map<String, String> properties) {
        super(properties);

        this.graphicsCard = new GraphicsCard();
        this.parameters = new GraphicsCardParameters();
        this.graphicsCard.setGraphicsCardParameters(parameters);
        this.graphicsCard.setComponentType("gpu");
    }

    @Override
    protected ComputerComponent buildComponent() {
        graphicsCard.setDescription(extractString(VALUE0));
        graphicsCard.setProducent(extractString(VALUE1));
        graphicsCard.setModel(extractString(VALUE2));

        parameters.setChipset(extractString(VALUE3));
        parameters.setMemory((int) numberParse(VALUE4, "memory"));
        parameters.setMemoryType(extractString(VALUE5));
        parameters.setMemoryFrequency(numberParse(VALUE6, "frequency"));
        parameters.setMainConnectorType(extractString(VALUE7));
        parameters.setLength(numberParse(VALUE8, "length"));
        parameters.setClockFrequency(numberParse(VALUE9, "clock frequency"));
        parameters.setResolution(extractString(VALUE10));
        parameters.setCooler(extractString(VALUE11));
        parameters.setStandards(convertToList(VALUE12));
        parameters.setConnectors(convertToList(VALUE13));

        return graphicsCard;
    }
}





















