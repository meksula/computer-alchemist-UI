package com.computeralchemist.desktop.gui.controller.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class SetGetPresenter extends ResultPresenter implements Initializable {

    @FXML
    private Label author, createDate, cpu, motherboard, ram, disk, gpu, supply, computercase;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        new ArrayList<Label>
                (Arrays.asList(cpu, motherboard, ram, disk, gpu, supply, computercase))
                .forEach(label -> {
                    label.setOnMouseEntered(event -> {
                        label.setTextFill(Color.ORANGE);
                    });
                    label.setOnMouseExited(event -> {
                        label.setTextFill(Color.WHITE);
                    });
                    label.setOnMouseClicked(event -> {
                        String choosenElement = label.getId();
                        presentChoosenComponent(choosenElement);
                    });
                });

        authorLabel();
        ramLabel();
        dateLabel();
        cpuLabel();
        motherboardLabel();
        diskLabel();
        gpuLabel();
        supplyLabel();
        caseLabel();
    }

    private void authorLabel() {
        if (computerSet.getAuthor() != null)
            author.setText(computerSet.getAuthor());
    }

    private void dateLabel() {
        if (computerSet.getCreateDate() != null)
            createDate.setText(computerSet.getCreateDate());
    }

    private void cpuLabel() {
        if (computerSet.getCpu() != null)
            cpu.setText(computerSet.getCpu().getProducent() + ", " + computerSet.getCpu().getModel());
    }

    private void motherboardLabel() {
        if (computerSet.getMotherboard() != null)
            motherboard.setText(computerSet.getMotherboard().getProducent() + ", " + computerSet.getMotherboard().getModel());
    }

    private void diskLabel() {
        if (computerSet.getDisk() != null)
            disk.setText(computerSet.getDisk().getProducent() + ", " + computerSet.getDisk().getModel());
    }

    private void gpuLabel() {
        if (computerSet.getGraphicsCard() != null)
            gpu.setText(computerSet.getGraphicsCard().getProducent() + ", " + computerSet.getGraphicsCard().getModel());
    }

    private void ramLabel() {
        if (computerSet.getRam() != null)
            ram.setText(computerSet.getRam().getProducent() + ", " + computerSet.getRam().getModel());
    }

    private void supplyLabel() {
        if (computerSet.getPowerSupply() != null)
            supply.setText(computerSet.getPowerSupply().getProducent() + ", " + computerSet.getPowerSupply().getModel());
    }

    private void caseLabel() {
        if (computerSet.getComputerCase() != null)
            computercase.setText(computerSet.getComputerCase().getProducent() + ", " + computerSet.getComputerCase().getModel());
    }

    @FXML
    public void editSet(ActionEvent actionEvent) {
    }

    private void presentChoosenComponent(String componentType) {
        setFxmlPath("/templates/parts/components/" + componentType + ".fxml");
        loadPresenter();
    }

    @Override
    protected String setFxmlPath() {
        return "/templates/parts/sets/" + fxmlName + ".fxml";
    }
}
