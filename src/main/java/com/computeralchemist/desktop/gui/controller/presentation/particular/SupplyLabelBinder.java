package com.computeralchemist.desktop.gui.controller.presentation.particular;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.supply.PowerSupply;
import com.computeralchemist.desktop.dto.components.supply.PowerSupplyParameters;
import javafx.scene.control.Label;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public class SupplyLabelBinder extends LabelBinder {
    private PowerSupply powerSupply;
    private PowerSupplyParameters parameters;
    private List<Label> labelList;

    @Override
    public void bindWithLabel(ComputerComponent computerComponent, List<Label> labelList) {
        this.powerSupply = (PowerSupply) computerComponent;
        this.parameters = powerSupply.getPowerSupplyParameters();
        this.labelList = labelList;

        bind();
    }

    private void bind() {
        labelList.get(0).setText(String.valueOf(powerSupply.getProducent()));
        labelList.get(1).setText(String.valueOf(powerSupply.getModel()));
        labelList.get(2).setText(String .valueOf(powerSupply.getVotes()));
        labelList.get(3).setText(String .valueOf(powerSupply.getRatesEvg()));
        labelList.get(4).setText(String .valueOf(parameters.getStandard()));
        labelList.get(5).setText(String .valueOf(parameters.getPower()));
        labelList.get(6).setText(String .valueOf(parameters.getPfc()));
        labelList.get(7).setText(String .valueOf(parameters.getCooler()));
        labelList.get(8).setText(String .valueOf(parameters.isModularCable()));

        addActionAndTooltip(labelList.get(9), parameters.getConnectors());
    }

    @Override
    public ComputerComponent updateValues() {
        powerSupply.setProducent(labelList.get(0).getText());
        powerSupply.setModel(labelList.get(1).getText());
        powerSupply.setVotes(Long.parseLong(labelList.get(2).getText()));
        powerSupply.setRatesEvg(Double.parseDouble(labelList.get(3).getText()));
        parameters.setStandard(labelList.get(4).getText());
        parameters.setPower(Integer.parseInt(labelList.get(5).getText()));
        parameters.setPfc(labelList.get(6).getText());
        parameters.setCooler(labelList.get(7).getText());
        parameters.setModularCable(Boolean.parseBoolean(labelList.get(8).getText()));

        return powerSupply;
    }

}