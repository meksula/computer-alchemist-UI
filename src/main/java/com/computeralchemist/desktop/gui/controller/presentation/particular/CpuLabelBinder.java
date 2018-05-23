package com.computeralchemist.desktop.gui.controller.presentation.particular;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.dto.components.cpu.CpuParameters;
import javafx.scene.control.Label;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public class CpuLabelBinder extends LabelBinder {
    private Cpu cpu;
    private CpuParameters parameters;
    private List<Label> labelList;

    @Override
    public void bindWithLabel(ComputerComponent computerComponent, List<Label> labelList) {
        this.cpu = (Cpu) computerComponent;
        this.labelList = labelList;
        this.parameters = cpu.getCpuParameters();

        bind();
    }

    private void bind() {
        labelList.get(0).setText(cpu.getProducent());
        labelList.get(1).setText(cpu.getModel());
        labelList.get(2).setText(String.valueOf(cpu.getVotes()));
        labelList.get(3).setText(String.valueOf(cpu.getRatesEvg()));
        labelList.get(4).setText(String.valueOf(parameters.getCores()));
        labelList.get(5).setText(String.valueOf(parameters.getSeries()));
        labelList.get(6).setText(String.valueOf(parameters.getSocket()));
        labelList.get(7).setText(String.valueOf(parameters.getThreads()));
        labelList.get(8).setText(String.valueOf(parameters.getBitArchitecture()));
        labelList.get(9).setText(String.valueOf(parameters.getCache()));
        labelList.get(10).setText(String.valueOf(parameters.getFrequency()));
    }

    @Override
    public ComputerComponent updateValues() {
        cpu.setProducent(labelList.get(0).getText());
        cpu.setModel(labelList.get(1).getText());
        cpu.setVotes(Long.parseLong(labelList.get(2).getText()));
        cpu.setRatesEvg(Double.parseDouble(labelList.get(3).getText()));
        parameters.setCores(Integer.parseInt(labelList.get(4).getText()));
        parameters.setSeries(labelList.get(5).getText());
        parameters.setSocket(labelList.get(6).getText());
        parameters.setThreads(Integer.parseInt(labelList.get(7).getText()));
        parameters.setBitArchitecture(labelList.get(8).getText());
        parameters.setCache(Integer.parseInt(labelList.get(9).getText()));
        parameters.setFrequency(Double.parseDouble(labelList.get(10).getText()));
        return cpu;
    }

}