package com.computeralchemist.desktop.dto.creator;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.dto.components.cpu.CpuParameters;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class CpuCreator extends ComponentCreator {
    private Cpu computerComponent;
    private CpuParameters parameters;
    private Map<String, String> properties;

    public CpuCreator(Map<String, String> properties) {
        super(properties);

        computerComponent = new Cpu();
        parameters = new CpuParameters();
        computerComponent.setCpuParameters(parameters);
        computerComponent.setComponentType("cpu");
    }

    @Override
    protected ComputerComponent buildComponent() {
        setProducent();
        setModel();
        setDescription();
        setCores();
        setSeries();
        setSocket();
        setThreads();
        setBitArchitecture();
        setCache();
        setFrequency();

        return computerComponent;
    }

    private void setProducent() {
        computerComponent.setProducent(extractString(VALUE1));
    }

    private void setModel() {
       computerComponent.setModel(extractString(VALUE2));
    }

    private void setDescription() {
       computerComponent.setDescription(extractString(VALUE0));
    }

    private void setCores() {
        parameters.setCores((int) numberParse(VALUE3, "cores"));
    }

    private void setSeries() {
        parameters.setSeries(extractString(VALUE4));
    }

    private void setSocket() {
        parameters.setSocket(extractString(VALUE5));
    }

    private void setThreads() {
        parameters.setThreads((int) numberParse(VALUE6, "threads"));
    }

    private void setBitArchitecture() {
        parameters.setBitArchitecture(extractString(VALUE7));
    }

    private void setCache() {
        parameters.setCache((int) numberParse(VALUE8, "cache"));
    }

    private void setFrequency() {
        parameters.setFrequency(numberParse(VALUE9, "frequency"));
    }

}
