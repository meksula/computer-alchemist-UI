package com.computeralchemist.desktop.gui.controller.presentation.particular;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.motherboard.Motherboard;
import com.computeralchemist.desktop.dto.components.motherboard.MotherboardParameters;
import javafx.scene.control.Label;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public class MotherboardLabelBinder extends LabelBinder {
    private Motherboard motherboard;
    private MotherboardParameters parameters;
    private List<Label> labelList;

    @Override
    public void bindWithLabel(ComputerComponent computerComponent, List<Label> labelList) {
        this.motherboard = (Motherboard) computerComponent;
        this.parameters = motherboard.getMotherboardParameters();
        this.labelList = labelList;

        bind();
    }

    private void bind() {
        labelList.get(0).setText(String.valueOf(motherboard.getProducent()));
        labelList.get(1).setText(String.valueOf(motherboard.getModel()));
        labelList.get(2).setText(String.valueOf(motherboard.getVotes()));
        labelList.get(3).setText(String.valueOf(motherboard.getRatesEvg()));
        labelList.get(4).setText(String.valueOf(parameters.getType()));
        labelList.get(5).setText(String.valueOf(parameters.getChipset()));
        labelList.get(6).setText(String.valueOf(parameters.getSocket()));
        labelList.get(7).setText(String.valueOf(parameters.getRamSockets()));
        labelList.get(8).setText(String.valueOf(parameters.getBios()));
        labelList.get(9).setText(String.valueOf(parameters.getMemoryType()));
        labelList.get(10).setText(String.valueOf(parameters.getMemoryFrequency()));

        labelList.get(11).setText(String.valueOf(parameters.getProcesorAvailables()));
        labelList.get(12).setText(String.valueOf(parameters.getOtherSockets()));

        addActionAndTooltip(labelList.get(11), parameters.getProcesorAvailables());
        addActionAndTooltip(labelList.get(12), parameters.getOtherSockets());
    }

    @Override
    public ComputerComponent updateValues() {
        motherboard.setProducent(labelList.get(0).getText());
        motherboard.setModel(labelList.get(1).getText());
        motherboard.setVotes(Long.parseLong(labelList.get(2).getText()));
        motherboard.setRatesEvg(Double.parseDouble(labelList.get(3).getText()));
        parameters.setType(labelList.get(4).getText());
        parameters.setChipset(labelList.get(5).getText());
        parameters.setSocket(labelList.get(6).getText());
        parameters.setRamSockets(Integer.parseInt(labelList.get(7).getText()));
        parameters.setBios(labelList.get(8).getText());
        parameters.setMemoryType(labelList.get(9).getText());
        parameters.setMemoryFrequency(Double.parseDouble(labelList.get(10).getText()));

        return motherboard;
    }

}