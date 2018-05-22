package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.disk.Disk;
import com.computeralchemist.desktop.dto.components.disk.DiskParameters;
import com.computeralchemist.desktop.dto.components.disk.DriveType;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class DiskCreator extends ComponentCreator {
    private Disk disk;
    private DiskParameters parameters;

    public DiskCreator(Map<String, String> properties) {
        super(properties);

        this.disk = new Disk();
        this.parameters = new DiskParameters();
        this.disk.setDiskParameters(parameters);
        this.disk.setComponentType("disk");
    }

    @Override
    protected ComputerComponent buildComponent() {
        disk.setDescription(extractString(VALUE0));
        disk.setProducent(extractString(VALUE1));
        disk.setModel(extractString(VALUE2));

        parameters.setType(DriveType.valueOf(extractString(VALUE3)));
        parameters.setFormat(extractString(VALUE4));
        parameters.setCapacity((int) numberParse(VALUE5, "capacity"));
        parameters.setReadSpeed(numberParse(VALUE6, "read speed"));
        parameters.setWriteSpeed(numberParse(VALUE7, "write speed"));

        return disk;
    }
}