package com.computeralchemist.desktop.logic.mapping;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.computerCase.ComputerCase;
import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.dto.components.disk.Disk;
import com.computeralchemist.desktop.dto.components.gpu.GraphicsCard;
import com.computeralchemist.desktop.dto.components.motherboard.Motherboard;
import com.computeralchemist.desktop.dto.components.ram.Ram;
import com.computeralchemist.desktop.dto.components.supply.PowerSupply;
import com.computeralchemist.desktop.exception.CannotReadTypeException;
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
