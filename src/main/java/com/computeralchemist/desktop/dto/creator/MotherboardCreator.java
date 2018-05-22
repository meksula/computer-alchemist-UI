package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.motherboard.Motherboard;
import com.computeralchemist.desktop.dto.components.motherboard.MotherboardParameters;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class MotherboardCreator extends ComponentCreator {
    private Motherboard motherboard;
    private MotherboardParameters parameters;

    public MotherboardCreator(Map<String, String> properties) {
        super(properties);

        motherboard = new Motherboard();
        parameters = new MotherboardParameters();
        motherboard.setMotherboardParameters(parameters);
        motherboard.setComponentType("motherboard");
    }

    @Override
    protected ComputerComponent buildComponent() {
        setDescription();
        setProducent();
        setModel();
        setType();
        setChipset();
        setSocket();
        setRamSlots();
        setBios();
        setMemoryType();
        setFrequency();
        setPocessorsAvailable();
        setOtherSockets();

        return motherboard;
    }

    private void setDescription() {
        motherboard.setDescription(extractString(VALUE0));
    }

    private void setProducent() {
        motherboard.setProducent(extractString(VALUE1));
    }

    private void setModel() {
        motherboard.setModel(extractString(VALUE2));
    }

    private void setType() {
       parameters.setType(extractString(VALUE3));
    }

    private void setChipset() {
        parameters.setChipset(extractString(VALUE4));
    }

    private void setSocket() {
        parameters.setSocket(extractString(VALUE5));
    }

    private void setRamSlots() {
        parameters.setRamSockets((int) numberParse(VALUE6, "ram sockets"));
    }

    private void setBios() {
        parameters.setBios(extractString(VALUE7));
    }

    private void setMemoryType() {
        parameters.setMemoryType(extractString(VALUE8));
    }

    private void setFrequency() {
        parameters.setMemoryFrequency(numberParse(VALUE9, "frequency"));
    }

    private void setPocessorsAvailable() {
        parameters.setProcesorAvailables(convertToList(VALUE10));
    }

    private void setOtherSockets() {
        parameters.setOtherSockets(convertToList(VALUE11));
    }

}
