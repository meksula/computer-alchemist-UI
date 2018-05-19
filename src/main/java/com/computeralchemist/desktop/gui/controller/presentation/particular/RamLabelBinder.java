package com.computeralchemist.desktop.gui.controller.presentation.particular;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.ram.Ram;
import com.computeralchemist.desktop.dto.components.ram.RamParameters;
import javafx.scene.control.Label;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public class RamLabelBinder extends LabelBinder {
    private Ram ram;
    private RamParameters parameters;
    private List<Label> labelList;

    @Override
    public void bindWithLabel(ComputerComponent computerComponent, List<Label> labelList) {
        this.ram = (Ram) computerComponent;
        this.parameters = ram.getRamParameters();
        this.labelList = labelList;

        bind();
    }

    private void bind() {
        labelList.get(0).setText(String.valueOf(ram.getProducent()));
        labelList.get(1).setText(String.valueOf(ram.getModel()));
        labelList.get(2).setText(String.valueOf(ram.getVotes()));
        labelList.get(3).setText(String.valueOf(ram.getRatesEvg()));
        labelList.get(4).setText(String.valueOf(parameters.getMemoryType()));
        labelList.get(5).setText(String.valueOf(parameters.getCooler()));
        labelList.get(6).setText(String.valueOf(parameters.getModules()));
        labelList.get(7).setText(String.valueOf(parameters.getCapacityGb()));
        labelList.get(8).setText(String.valueOf(parameters.getFrequency()));
        labelList.get(9).setText(String.valueOf(parameters.getSocketType()));
    }

}