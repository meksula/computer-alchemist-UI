package com.computeralchemist.consoleUI.gui.ui.factory;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.motherboard.Motherboard;
import com.computeralchemist.desktop.dto.components.motherboard.MotherboardParameters;
import com.computeralchemist.consoleUI.exception.FormNotCompleteException;
import com.computeralchemist.consoleUI.exception.InvalidInputException;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 09-05-2018
 * */

public class MotherboardFactory extends ComponentFactory {
    private ComputerComponent computerComponent;
    private MotherboardParameters parameters;
    private Map<String, String> properties;

    private final String PRODUCENT = "producent";
    private final String MODEL = "logic";
    private final String DESCRIPTION = "description";
    private final String TYPE = "type";
    private final String CHIPSET = "chipset";
    private final String SOCKET = "socket";
    private final String RAM_SOCKETS = "ramSockets";
    private final String BIOS = "bios";
    private final String MEMORY_TYPE = "memoryType";
    private final String MEMORY_FREQUENCY = "memoryFrequency";
    private final String PROCESORS_AVAILABLE = "procesorAvailables";
    private final String OTHER_SOCKETS = "otherSockets";

    public MotherboardFactory() {
        parameters = new MotherboardParameters();
        computerComponent = new Motherboard();
        ((Motherboard) computerComponent).setMotherboardParameters(parameters);
    }

    @Override
    public ComputerComponent createComponent(Map<String, String> properties) {
        this.properties = properties;

        computerComponent.setComponentType("motherboard");
        setProducent();
        setModel();
        setDescription();
        setType();
        setChipset();
        setSocket();
        setRamSockets();
        setBios();
        setMemoryType();
        setMemoryFrequency();
        setProcessorsAvailable();
        setOtherSockets();

        return computerComponent;
    }

    private void setProducent() {
        String producent = properties.get(PRODUCENT);

        if (producent == null)
            throw new FormNotCompleteException();

        computerComponent.setProducent(producent);
    }

    private void setModel() {
        String model = properties.get(MODEL);

        if (model == null)
            throw new FormNotCompleteException();

        computerComponent.setModel(model);
    }

    private void setDescription() {
        String description = properties.get(DESCRIPTION);

        if (description == null)
            throw new FormNotCompleteException();

        computerComponent.setDescription(description);
    }

    private void setType() {
        String type = properties.get(TYPE);

        if (type == null)
            throw new FormNotCompleteException();

        parameters.setType(type);
    }

    private void setChipset() {
        String chipset = properties.get(CHIPSET);

        if (chipset == null)
            throw new FormNotCompleteException();

        parameters.setChipset(chipset);
    }

    private void setSocket() {
        String socket = properties.get(SOCKET);

        if (socket == null)
            throw new FormNotCompleteException();

        parameters.setSocket(socket);
    }

    private void setRamSockets() {
        int slots;

        try {
            slots = Integer.parseInt(properties.get(RAM_SOCKETS));
        } catch (NumberFormatException nfe){
            throw new InvalidInputException("Ram sockets");
        }

        parameters.setRamSockets(slots);
    }

    private void setBios() {
        String bios = properties.get(BIOS);

        if (bios == null)
            throw new FormNotCompleteException();

        parameters.setBios(bios);
    }

    private void setMemoryType() {
        String memoryType = properties.get(MEMORY_TYPE);

        if (memoryType == null)
            throw new FormNotCompleteException();

        parameters.setMemoryType(memoryType);
    }

    private void setMemoryFrequency() {
        double frequency;

        try {
            frequency = Double.parseDouble(properties.get(MEMORY_FREQUENCY));
        } catch (NumberFormatException nfe) {
            throw new InvalidInputException("Memory frequency");
        }

        parameters.setMemoryFrequency(frequency);
    }

    private void setProcessorsAvailable() {
       /* List<String> processorsAvailable = super.stringToPropertyList(properties.get(PROCESORS_AVAILABLE));

        if (processorsAvailable == null || processorsAvailable.size() == 0)
            throw new FormNotCompleteException();

        parameters.setProcesorAvailables(processorsAvailable);*/
    }

    private void setOtherSockets() {
       /* List<String> sockets = super.stringToPropertyList(properties.get(OTHER_SOCKETS));

        if (sockets == null || sockets.size() == 0)
            throw new FormNotCompleteException();

        parameters.setOtherSockets(sockets);*/
    }
}
