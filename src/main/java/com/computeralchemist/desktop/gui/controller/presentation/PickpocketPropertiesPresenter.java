package com.computeralchemist.desktop.gui.controller.presentation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public class PickpocketPropertiesPresenter extends ResultPresenter implements Initializable {
    private final String REQUIRED_FXML = "/templates/pickpocket/pickpocketPropertiesPresent.fxml";
    private static List<String> properties;

    @FXML
    private VBox vbox;

    public PickpocketPropertiesPresenter(List<String> properties) {
        PickpocketPropertiesPresenter.properties = properties;
    }

    @Override
    protected String setFxmlPath() {
        return REQUIRED_FXML;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawPropertiesLabel();
    }

    private void drawPropertiesLabel() {
        if (properties != null) {
            for (int i = 0; i < properties.size(); i++) {
                Label label = new Label();
                label.getStyleClass().add("txt");
                label.setText(properties.get(i));
                vbox.getChildren().add(label);
            }
        } else System.out.println("Properties hasn't set.");
    }


}
