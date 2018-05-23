package com.computeralchemist.desktop.gui.controller.presentation;

import com.computeralchemist.desktop.gui.controller.presentation.particular.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.*;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public class ComponentGetPresenter extends ResultPresenter implements Initializable {
    public static LabelBinder labelBinder;
    private String componentType;

    @FXML
    private Label value1, value2, value3, value4, value5, value6, value7, value8, value9,
                  value10, value11, value12, value13, value14, value15;

    @Override
    protected String setFxmlPath() {
        return "/templates/parts/components/" + fxmlName + ".fxml";
    }

    private static List<Label> labelList;
    private static Label decript;
    private static Map<String, String> properties;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        presenter.getChildren().clear();

        labelList = new ArrayList<>(Arrays.asList(value1, value2, value3, value4, value5, value6, value7, value8, value9,
                value10, value11, value12, value13, value14, value15));

        componentType = computerComponent.getComponentType();

        if (componentType.equals("cpu"))
            labelBinder = new CpuLabelBinder();
        if (componentType.equals("motherboard"))
            labelBinder = new MotherboardLabelBinder();
        if (componentType.equals("ram"))
            labelBinder = new RamLabelBinder();
        if (componentType.equals("disk"))
            labelBinder = new DiskLabelBinder();
        if (componentType.equals("gpu"))
            labelBinder = new GpuLabelBinder();
        if (componentType.equals("supply"))
            labelBinder = new SupplyLabelBinder();
        if (componentType.equals("computercase"))
            labelBinder = new CaseLabelBinder();

        labelBinder.bindWithLabel(computerComponent, labelList);
        presenter.getChildren().add(descriptionLabel());
    }

    private static Label descriptionLabel() {
        decript = new Label(computerComponent.getDescription());
        decript.setLayoutX(14);
        decript.setLayoutY(296);
        decript.setPrefWidth(550);
        decript.getStyleClass().add("txt");
        decript.setWrapText(true);
        decript.setTextAlignment(TextAlignment.JUSTIFY);
        return decript;
    }

    public static void addModificationable() {
        for (Label label : labelList) {
            if (label != null)
                label.setOnMouseClicked(event -> {
                    addAction(label);
                });
        }
        decript.setOnMouseClicked(event -> {
            addAction(decript);
        });
    }

    private static void addAction(Label label) {
        TextInputDialog inputDialog = new TextInputDialog(label.getText());
        inputDialog.setTitle("Data modification");
        inputDialog.setHeaderText("Type above correctly value: ");
        Optional<String> result = inputDialog.showAndWait();
        result.ifPresent(label::setText);
    }

    @FXML
    public void editComponent(ActionEvent actionEvent) {
    }
}
