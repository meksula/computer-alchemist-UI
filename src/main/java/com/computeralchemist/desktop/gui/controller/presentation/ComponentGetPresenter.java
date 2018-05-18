package com.computeralchemist.desktop.gui.controller.presentation;

import com.computeralchemist.desktop.gui.controller.presentation.particular.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public class ComponentGetPresenter extends ResultPresenter implements Initializable {
    private LabelBinder labelBinder;

    @FXML
    private Label value1, value2, value3, value4, value5, value6, value7, value8, value9,
                  value10, value11, value12, value13, value14, value15;

    @Override
    protected String setFxmlPath() {
        return "/templates/parts/components/" + fxmlName + ".fxml";
    }

    public void editComponent(ActionEvent actionEvent) {

    }

    private String componentType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        presenter.getChildren().clear();

        List<Label> labelList = new ArrayList<>(Arrays.asList(value1, value2, value3, value4, value5, value6, value7, value8, value9,
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

    private Label descriptionLabel() {
        Label label = new Label(computerComponent.getDescription());
        label.setLayoutX(14);
        label.setLayoutY(296);
        label.setPrefWidth(550);
        label.getStyleClass().add("txt");
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        return label;
    }


}
