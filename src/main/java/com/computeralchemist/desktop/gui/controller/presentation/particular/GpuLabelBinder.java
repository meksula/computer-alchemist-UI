package com.computeralchemist.desktop.gui.controller.presentation.particular;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.gpu.GraphicsCard;
import com.computeralchemist.desktop.dto.components.gpu.GraphicsCardParameters;
import javafx.scene.control.Label;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public class GpuLabelBinder extends LabelBinder {
    private GraphicsCard graphicsCard;
    private GraphicsCardParameters parameters;
    private List<Label> labelList;

    @Override
    public void bindWithLabel(ComputerComponent computerComponent, List<Label> labelList) {
        this.graphicsCard = (GraphicsCard) computerComponent;
        this.parameters = graphicsCard.getGraphicsCardParameters();
        this.labelList = labelList;

        bind();
    }

    private void bind() {
        labelList.get(0).setText(String.valueOf(graphicsCard.getProducent()));
        labelList.get(1).setText(String.valueOf(graphicsCard.getModel()));
        labelList.get(2).setText(String.valueOf(graphicsCard.getVotes()));
        labelList.get(3).setText(String.valueOf(graphicsCard.getRatesEvg()));
        labelList.get(4).setText(String.valueOf(parameters.getStandards()));
        labelList.get(5).setText(String.valueOf(parameters.getChipset()));
        labelList.get(6).setText(String.valueOf(parameters.getMemory()));
        labelList.get(7).setText(String.valueOf(parameters.getMemoryType()));
        labelList.get(8).setText(String.valueOf(parameters.getMemoryFrequency()));
        labelList.get(9).setText(String.valueOf(parameters.getMainConnectorType()));
        labelList.get(10).setText(String.valueOf(parameters.getLength()));
        labelList.get(11).setText(String.valueOf(parameters.getClockFrequency()));
        labelList.get(12).setText(String.valueOf(parameters.getResolution()));
        labelList.get(13).setText(String.valueOf(parameters.getCooler()));

        addActionAndTooltip(labelList.get(14), parameters.getConnectors());
    }

    @Override
    public ComputerComponent updateValues() {
        graphicsCard.setProducent(labelList.get(0).getText());
        graphicsCard.setModel(labelList.get(1).getText());
        graphicsCard.setVotes(Long.parseLong(labelList.get(2).getText()));
        graphicsCard.setRatesEvg(Double.parseDouble(labelList.get(3).getText()));
        parameters.setChipset(labelList.get(5).getText());
        parameters.setMemory(Integer.parseInt(labelList.get(6).getText()));
        parameters.setMemoryType(labelList.get(7).getText());
        parameters.setMemoryFrequency(Double.parseDouble(labelList.get(8).getText()));
        parameters.setMainConnectorType(labelList.get(9).getText());
        parameters.setLength(Double.parseDouble(labelList.get(10).getText()));
        parameters.setClockFrequency(Double.parseDouble(labelList.get(11).getText()));
        parameters.setResolution(labelList.get(12).getText());
        parameters.setCooler(labelList.get(13).getText());
        return graphicsCard;
    }

}