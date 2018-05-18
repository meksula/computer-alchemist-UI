package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.set.ComputerSet;
import com.computeralchemist.desktop.gui.controller.presentation.SetGetPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class SetPostButtonManager extends PaneManager implements Initializable {
    private static ComputerSet computerSet;
    private final String REQUIRED_FXML = "post/postSet";

    @FXML
    private Label cpuLabel, motherboardLabel, ramLabel, diskLabel, gpuLabel, supplyLabel, computercaseLabel;

    @FXML
    private CheckBox isPublic;

    @FXML
    private TextField computercaseId, cpuId, motherboardId, ramId, diskId, gpuId, supplyId;

    @FXML
    private RadioButton cpu, motherboard, ram, disk, gpu, supply, computercase;

    @FXML
    private Pane componentPrevievPane;

    @Override
    protected String fxmlName() {
        return REQUIRED_FXML;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paintLabel(new ArrayList<>(
                Arrays.asList(cpuLabel, motherboardLabel, ramLabel, diskLabel, gpuLabel, supplyLabel, computercaseLabel)));

        addActionsToButtons(new ArrayList<>(
                Arrays.asList(cpu, motherboard, ram, disk, gpu, supply, computercase)));

        addActionToTextFields(new ArrayList<>(
                Arrays.asList(computercaseId, cpuId, motherboardId, ramId, diskId, gpuId, supplyId)));

    }

    private void paintLabel(List<Label> labels) {
        labels.forEach(label -> {
            label.getStyleClass().clear();
            label.getStyleClass().add("empty");
        });
    }

    private void addActionsToButtons(List<RadioButton> buttons) {
        ToggleGroup toggleGroup = new ToggleGroup();

        buttons.forEach(button -> {
            button.setToggleGroup(toggleGroup);
            button.setOnMouseClicked(event -> {
                loadComponentView(button.getId());
            });
        });
    }

    private void addActionToTextFields(List<TextField> fields) {
        Tooltip tooltip = new Tooltip();
        tooltip.setText("First type productId value\nnext push `enter` to load component.");

        fields.forEach(field -> {
            field.setTooltip(tooltip);

            field.setOnKeyPressed(event -> {
                if (event.getCode().equals(KeyCode.ENTER))
                    System.out.println(field.getText());
            });
        });
    }

    private void loadComponentView(String componentType) {
        new SetGetPresenter().presentResult(componentPrevievPane, computerSet);
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) {
    }

    @FXML
    public void showBuildingSet(ActionEvent actionEvent) {
    }

    private void changeLabelColor() {
        if (computerSet.getCpu() != null)
            changeStyle(cpuLabel);
        if (computerSet.getMotherboard() != null)
            changeStyle(motherboardLabel);
        if (computerSet.getRam() != null)
            changeStyle(ramLabel);
        if (computerSet.getDisk() != null)
            changeStyle(diskLabel);
        if (computerSet.getGraphicsCard() != null)
            changeStyle(gpuLabel);
        if (computerSet.getPowerSupply() != null)
            changeStyle(supplyLabel);
        if (computerSet.getComputerCase() != null)
            changeStyle(computercaseLabel);
    }

    private void changeStyle(Label label) {
        label.getStyleClass().clear();
        label.getStyleClass().add("correctly");
    }

}
