package com.computeralchemist.desktop.dto.set;

import com.computeralchemist.desktop.dto.components.computerCase.ComputerCase;
import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.dto.components.disk.Disk;
import com.computeralchemist.desktop.dto.components.gpu.GraphicsCard;
import com.computeralchemist.desktop.dto.components.motherboard.Motherboard;
import com.computeralchemist.desktop.dto.components.ram.Ram;
import com.computeralchemist.desktop.dto.components.supply.PowerSupply;
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
