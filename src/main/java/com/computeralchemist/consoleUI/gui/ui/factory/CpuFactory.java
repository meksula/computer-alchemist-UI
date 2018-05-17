package com.computeralchemist.consoleUI.gui.ui.factory;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.dto.components.cpu.CpuParameters;
import com.computeralchemist.consoleUI.exception.FormNotCompleteException;
import com.computeralchemist.consoleUI.exception.InvalidInputException;
import lombok.Getter;

import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 08-05-2018
 * */

@Getter
public class CpuFactory extends ComponentFactory {
    private ComputerComponent computerComponent;
    private CpuParameters parameters;
    private Map<String, String> properties;

    private final String PRODUCENT = "producent";
    private final String MODEL = "model";
    private final String DESCRIPTION = "description";
    private final String CORES = "cores";
    private final String SERIES = "series";
    private final String SOCKET = "socket";
    private final String THREADS = "threads";
    private final String BIT_ARCH = "bitArchitecture";
    private final String CACHE = "cache";
    private final String FREQUENCY = "frequency";

    public CpuFactory() {
        computerComponent = new Cpu();
        parameters = new CpuParameters();
        ((Cpu) computerComponent).setCpuParameters(parameters);
        computerComponent.setComponentType("cpu");

        System.out.println("Instantiated");
    }

    @Override
    public ComputerComponent createComponent(Map<String, String> properties) {
        this.properties = properties;

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
        String producent = properties.get(PRODUCENT);

        if (producent == null) {
            throw new FormNotCompleteException();
        }

        computerComponent.setProducent(producent);
    }

    private void setModel() {
        String model = properties.get(MODEL);

        if (model == null)
            throw new FormNotCompleteException();

        computerComponent.setModel(model);
    }

    private void setDescription() {
        String description = properties.get(DESCRIPTION);

        if (description == null)
            throw new FormNotCompleteException();

        computerComponent.setDescription(description);
    }

    private void setCores() {
        int cores;
        try {
            cores = Integer.parseInt(properties.get(CORES));
        } catch (NumberFormatException nfe){
            throw new FormNotCompleteException();
        }

        parameters.setCores(cores);
    }

    private void setSeries() {
        String series = properties.get(SERIES);

        if (series == null)
            throw new FormNotCompleteException();

        parameters.setSeries(series);
    }

    private void setSocket() {
        String socket = properties.get(SOCKET);

        if (socket == null)
            throw new FormNotCompleteException();

        parameters.setSocket(socket);
    }

    private void setThreads() {
        String threadString = properties.get(THREADS);
        int threads;

        try {
            threads = Integer.parseInt(threadString);
        } catch (NumberFormatException nfe) {
            throw new InvalidInputException(THREADS);
        }

        parameters.setThreads(threads);
    }

    private void setBitArchitecture() {
        String bitArch = properties.get(BIT_ARCH);

        if (bitArch == null)
            throw new FormNotCompleteException();

        parameters.setBitArchitecture(bitArch);
    }

    private void setCache() {
        int cache;
        try {
            cache = Integer.parseInt(properties.get(CACHE));
        } catch (NumberFormatException nfo) {
            throw new InvalidInputException("cache");
        }

        parameters.setCache(cache);
    }

    private void setFrequency() {
        double frequency;
        try {
            frequency = Double.parseDouble(properties.get(CACHE));
        } catch (NumberFormatException | NullPointerException nfe) {
            throw new InvalidInputException(CACHE);
        }

        parameters.setFrequency(frequency);
    }

}
