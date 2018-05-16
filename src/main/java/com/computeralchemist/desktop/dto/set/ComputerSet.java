package com.computeralchemist.desktop.dto.set;

import com.computeralchemist.consoleUI.components.computerCase.ComputerCase;
import com.computeralchemist.consoleUI.components.cpu.Cpu;
import com.computeralchemist.consoleUI.components.disk.Disk;
import com.computeralchemist.consoleUI.components.gpu.GraphicsCard;
import com.computeralchemist.consoleUI.components.motherboard.Motherboard;
import com.computeralchemist.consoleUI.components.ram.Ram;
import com.computeralchemist.consoleUI.components.supply.PowerSupply;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class ComputerSet {

    public abstract long getSetId();

    private ComputerSetTypes type;
    private String author;
    private String createDate;
    private long votes;
    private boolean compatible;
    private boolean finished;
    private boolean isPublic = true;

    private Cpu cpu;
    private Motherboard motherboard;
    private Ram ram;
    private Disk disk;
    private GraphicsCard graphicsCard;
    private PowerSupply powerSupply;
    private ComputerCase computerCase;

}
