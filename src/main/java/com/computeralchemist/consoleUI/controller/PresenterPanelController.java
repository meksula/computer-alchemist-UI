package com.computeralchemist.consoleUI.controller;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import com.computeralchemist.consoleUI.components.computerCase.ComputerCase;
import com.computeralchemist.consoleUI.components.computerCase.ComputerCaseParameters;
import com.computeralchemist.consoleUI.components.cpu.Cpu;
import com.computeralchemist.consoleUI.components.cpu.CpuParameters;
import com.computeralchemist.consoleUI.components.disk.Disk;
import com.computeralchemist.consoleUI.components.disk.DiskParameters;
import com.computeralchemist.consoleUI.components.gpu.GraphicsCard;
import com.computeralchemist.consoleUI.components.gpu.GraphicsCardParameters;
import com.computeralchemist.consoleUI.components.motherboard.Motherboard;
import com.computeralchemist.consoleUI.components.motherboard.MotherboardParameters;
import com.computeralchemist.consoleUI.components.ram.Ram;
import com.computeralchemist.consoleUI.components.ram.RamParameters;
import com.computeralchemist.consoleUI.components.supply.PowerSupply;
import com.computeralchemist.consoleUI.components.supply.PowerSupplyParameters;
import com.computeralchemist.consoleUI.gui.dataPresentation.DataPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import lombok.EqualsAndHashCode;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author
 * Karol Meksuła
 * 29-04-2018
 * */

@EqualsAndHashCode
public class PresenterPanelController implements Initializable {

    @FXML
    private Label producent, model, votes, rates;

    @FXML
    private Label cores, series, socket, threads, bit, frequency, cache;

    @FXML
    private Label others, type, chipset, socketMobo, ramSockets, bios, memoryType, memoryFrequency, cpuAvailable;

    @FXML
    private Label cooler, modules, capacity;

    @FXML
    private Label format, readSpeed, writeSpeed;

    @FXML
    private Label standard, power, pfc, modularCables, connectors;

    @FXML
    private Label resolution, memory, length, clockFrequency, standards, connector;

    @FXML
    private Label height, width, weight, compatibleMotherboards;

    private ComputerComponent component;
    private Pane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pane = DataPresenter.presenter;
    }

    public void displayObjectData(ComputerComponent component) {
        this.component = component;

        presentAny();

        if (component.getComponentType().equals("cpu"))
            presentCpu();
        else if (component.getComponentType().equals("motherboard"))
            presentMotherboard();
        else if (component.getComponentType().equals("ram"))
            presentRam();
        else if (component.getComponentType().equals("disk"))
            presentDisk();
        else if (component.getComponentType().equals("supply"))
            presentSupply();
        else if (component.getComponentType().equals("gpu"))
            presentGpu();
        else if (component.getComponentType().equals("computercase"))
            presentComputerCase();
    }

    private void presentAny() {
        producent.setText(component.getProducent());
        model.setText(component.getModel());
        votes.setText(String.valueOf(component.getVotes()));
        rates.setText(String.valueOf(component.getRatesEvg()));
        pane.getChildren().add(drawDescriptionLabel(component.getDescription()));
    }

    private Label drawDescriptionLabel(String text) {
        Label label = new Label();
        label.setText(text);
        label.setTextFill(Color.valueOf("#efe3ee"));
        label.setLayoutX(14);
        label.setLayoutY(300);
        label.setPrefWidth(490);
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        return label;
    }

    private void presentCpu() {
        Cpu cpu = (Cpu) component;
        CpuParameters param = cpu.getCpuParameters();

        cores.setText(String.valueOf(param.getCores()));
        series.setText(String.valueOf(param.getSeries()));
        socket.setText(String.valueOf(param.getSocket()));
        threads.setText(String.valueOf(param.getThreads()));
        bit.setText(String.valueOf(param.getBitArchitecture()));
        frequency.setText(String.valueOf(param.getFrequency()));
        cache.setText(String.valueOf(param.getCache()));
    }

    private void presentMotherboard() {
        Motherboard motherboard = (Motherboard) component;
        MotherboardParameters param = motherboard.getMotherboardParameters();

        type.setText(param.getType());
        chipset.setText(param.getChipset());
        socketMobo.setText(param.getChipset());
        ramSockets.setText(String.valueOf(param.getRamSockets()));
        bios.setText(param.getBios());
        memoryType.setText(param.getMemoryType());
        memoryFrequency.setText(String.valueOf(param.getMemoryFrequency()));

        drawList(cpuAvailable, param.getProcesorAvailables());
        drawList(others, param.getOtherSockets());
    }

    private void drawList(Label label, List<String> list) {
        label.setText(list.get(0));

        AtomicInteger counter = new AtomicInteger(1);
        label.setOnMouseClicked(event -> {
            if (counter.get() >= list.size() - 1)
                counter.set(0);

            if (list.size() <= 1)
                label.setText(list.get(0));

            else {
                counter.getAndIncrement();
                label.setText(list.get(counter.get()));
            }
        });
    }

    private void presentRam() {
        Ram ram = (Ram) component;
        RamParameters param = ram.getRamParameters();

        memoryType.setText(param.getMemoryType());
        cooler.setText(param.getCooler());
        modules.setText(String.valueOf(param.getModules()));
        capacity.setText(String.valueOf(param.getCapacityGb()));
        frequency.setText(String.valueOf(param.getFrequency()));
        socket.setText(param.getSocketType());
    }

    private void presentDisk() {
        Disk disk = (Disk) component;
        DiskParameters param = disk.getDiskParameters();

        type.setText(param.getType().toString());
        format.setText(param.getFormat());
        capacity.setText(String.valueOf(param.getCapacity()));
        readSpeed.setText(String.valueOf(param.getReadSpeed()));
        writeSpeed.setText(String.valueOf(param.getWriteSpeed()));
    }

    private void presentSupply() {
        PowerSupply powerSupply = (PowerSupply) component;
        PowerSupplyParameters param = powerSupply.getPowerSupplyParameters();

        standard.setText(param.getStandard());
        pfc.setText(param.getPfc());
        power.setText(String.valueOf(param.getPower()));
        cooler.setText(param.getCooler());
        modularCables.setText(String.valueOf(param.isModularCable()));
        drawList(connectors, param.getConnectors());
    }

    private void presentGpu() {
        GraphicsCard graphicsCard = (GraphicsCard) component;
        GraphicsCardParameters param = graphicsCard.getGraphicsCardParameters();

        chipset.setText(param.getChipset());
        memory.setText(String.valueOf(param.getMemory()));
        memoryType.setText(param.getMemoryType());
        memoryFrequency.setText(String.valueOf(param.getMemoryFrequency()));
        connector.setText(param.getMainConnectorType());
        clockFrequency.setText(String.valueOf(param.getClockFrequency()));
        resolution.setText(param.getResolution());
        cooler.setText(param.getCooler());

        drawList(standards, param.getStandards());
        drawList(connectors, param.getConnectors());
    }

    private void presentComputerCase() {
        ComputerCase computerCase = (ComputerCase) component;
        ComputerCaseParameters param = computerCase.getComputerCaseParameters();

        type.setText(param.getType());
        height.setText(String.valueOf(param.getHeight()));
        width.setText(String.valueOf(param.getWidth()));
        weight.setText(String.valueOf(param.getWeight()));

        drawList(compatibleMotherboards, param.getCompatibilityMotherboards());
        drawList(connectors, param.getConnectors());
    }

    @FXML
    public void editComponent(ActionEvent actionEvent) {

    }
}
