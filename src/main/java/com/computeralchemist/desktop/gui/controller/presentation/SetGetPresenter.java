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
    private String resourcePath = "";

    @FXML
    private Label author, createDate, votes, cpu, motherboard, ram, disk, gpu, supply, computercase;

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
