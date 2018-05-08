package com.computeralchemist.consoleUI.mapping;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import com.computeralchemist.consoleUI.components.computerCase.ComputerCase;
import com.computeralchemist.consoleUI.components.cpu.Cpu;
import com.computeralchemist.consoleUI.components.disk.Disk;
import com.computeralchemist.consoleUI.components.gpu.GraphicsCard;
import com.computeralchemist.consoleUI.components.motherboard.Motherboard;
import com.computeralchemist.consoleUI.components.ram.Ram;
import com.computeralchemist.consoleUI.components.supply.PowerSupply;
import com.computeralchemist.consoleUI.exception.CannotReadTypeException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public class ObjectMapperSimpleFactory {
    private ObjectMapper objectMapper;

    public ObjectMapperSimpleFactory() {
        objectMapper = new ObjectMapper();
    }

    public ComputerComponent mapByType(String json, String type) throws IOException {

        if (type.equals("cpu"))
            return objectMapper.readValue(json, Cpu.class);
        else if (type.equals("motherboard"))
            return objectMapper.readValue(json, Motherboard.class);
        else if (type.equals("ram"))
            return objectMapper.readValue(json, Ram.class);
        else if (type.equals("disk"))
            return objectMapper.readValue(json, Disk.class);
        else if (type.equals("supply"))
            return objectMapper.readValue(json, PowerSupply.class);
        else if (type.equals("computercase"))
            return objectMapper.readValue(json, ComputerCase.class);
        else if (type.equals("gpu"))
            return objectMapper.readValue(json, GraphicsCard.class);

        throw new CannotReadTypeException(type);
    }

    public List<ComputerComponent> mapToListByType(String json, String type) throws IOException {
        if (type.equals("cpu"))
            return objectMapper.readValue(json, new TypeReference<List<Cpu>>(){});
        else if (type.equals("motherboard"))
            return objectMapper.readValue(json, new TypeReference<List<Motherboard>>(){});
        else if (type.equals("ram"))
            return objectMapper.readValue(json, new TypeReference<List<Ram>>(){});
        else if (type.equals("disk"))
            return objectMapper.readValue(json, new TypeReference<List<Disk>>(){});
        else if (type.equals("supply"))
            return objectMapper.readValue(json, new TypeReference<List<PowerSupply>>(){});
        else if (type.equals("computercase"))
            return objectMapper.readValue(json, new TypeReference<List<ComputerCase>>(){});
        else if (type.equals("gpu"))
            return objectMapper.readValue(json, new TypeReference<List<GraphicsCard>>(){});

        throw new CannotReadTypeException(type);
    }


}
