package com.computeralchemist.desktop.gui.controller.presentation.particular;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.disk.Disk;
import com.computeralchemist.desktop.dto.components.disk.DiskParameters;
import com.computeralchemist.desktop.dto.components.disk.DriveType;
import javafx.scene.control.Label;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public class DiskLabelBinder extends LabelBinder {
    private Disk disk;
    private DiskParameters parameters;
    private List<Label> labelList;

    @Override
    public void bindWithLabel(ComputerComponent computerComponent, List<Label> labelList) {
        this.disk = (Disk) computerComponent;
        this.parameters = disk.getDiskParameters();
        this.labelList = labelList;

        build();
    }

    private void build() {
        labelList.get(0).setText(String.valueOf(disk.getProducent()));
        labelList.get(1).setText(String.valueOf(disk.getModel()));
        labelList.get(2).setText(String.valueOf(disk.getVotes()));
        labelList.get(3).setText(String.valueOf(disk.getRatesEvg()));
        labelList.get(4).setText(String.valueOf(parameters.getType()));
        labelList.get(5).setText(String.valueOf(parameters.getFormat()));
        labelList.get(6).setText(String.valueOf(parameters.getCapacity()));
        labelList.get(7).setText(String.valueOf(parameters.getReadSpeed()));
        labelList.get(8).setText(String.valueOf(parameters.getWriteSpeed()));
    }

    @Override
    public ComputerComponent updateValues() {
        disk.setProducent(labelList.get(0).getText());
        disk.setModel(labelList.get(1).getText());
        disk.setVotes(Long.parseLong(labelList.get(2).getText()));
        disk.setRatesEvg(Double.parseDouble(labelList.get(3).getText()));
        parameters.setType(DriveType.valueOf(labelList.get(4).getText()));
        parameters.setFormat(labelList.get(5).getText());
        parameters.setCapacity(Integer.parseInt(labelList.get(6).getText()));
        parameters.setReadSpeed(Double.parseDouble(labelList.get(7).getText()));
        parameters.setWriteSpeed(Double.parseDouble(labelList.get(8).getText()));
        return disk;
    }

}









