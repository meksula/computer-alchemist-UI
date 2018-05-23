package com.computeralchemist.desktop.gui.controller.presentation.particular;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.computerCase.ComputerCase;
import com.computeralchemist.desktop.dto.components.computerCase.ComputerCaseParameters;
import javafx.scene.control.Label;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public class CaseLabelBinder extends LabelBinder {
    private ComputerCase computerCase;
    private ComputerCaseParameters parameters;
    private List<Label> labelList;

    @Override
    public void bindWithLabel(ComputerComponent computerComponent, List<Label> labelList) {
        this.computerCase = (ComputerCase) computerComponent;
        this.parameters = computerCase.getComputerCaseParameters();
        this.labelList = labelList;

        bind();
    }

    private void bind() {
        labelList.get(0).setText(String.valueOf(computerCase.getProducent()));
        labelList.get(1).setText(String.valueOf(computerCase.getModel()));
        labelList.get(2).setText(String.valueOf(computerCase.getVotes()));
        labelList.get(3).setText(String.valueOf(computerCase.getRatesEvg()));
        labelList.get(4).setText(String.valueOf(parameters.getType()));
        labelList.get(5).setText(String.valueOf(parameters.getHeight()));
        labelList.get(6).setText(String.valueOf(parameters.getWidth()));
        labelList.get(7).setText(String.valueOf(parameters.getWeight()));

        addActionAndTooltip(labelList.get(8), parameters.getCompatibilityMotherboards());
        addActionAndTooltip(labelList.get(9), parameters.getConnectors());
    }

    @Override
    public ComputerComponent updateValues() {
        computerCase.setProducent(labelList.get(0).getText());
        computerCase.setModel(labelList.get(1).getText());
        computerCase.setVotes(Long.parseLong(labelList.get(2).getText()));
        computerCase.setRatesEvg(Double.parseDouble(labelList.get(3).getText()));
        parameters.setType(labelList.get(4).getText());
        parameters.setHeight(Double.parseDouble(labelList.get(5).getText()));
        parameters.setWidth(Double.parseDouble(labelList.get(6).getText()));
        parameters.setWeight(Double.parseDouble(labelList.get(7).getText()));

        return computerCase;
    }

}









