package com.computeralchemist.desktop.gui.controller.presentation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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
    public static String textCache;

    @FXML
    private VBox vbox;

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
                makeLabelCopyable(label);
                makeLabelStyle(label);
                vbox.getChildren().add(label);
            }
        } else System.out.println("Properties hasn't set.");
    }

    private void makeLabelStyle(Label label) {
        Tooltip tooltip = new Tooltip();
        tooltip.setText("Click at property\nto copy text.");
        label.setTooltip(tooltip);

        String baseColor = "#efe3ee";
        label.setOnMouseEntered(event -> {
            label.setTextFill(Color.YELLOW);
        });

        label.setOnMouseExited(event -> {
            label.setTextFill(Paint.valueOf(baseColor));
        });
    }

    private void makeLabelCopyable(Label label) {
        label.setOnMouseClicked(event -> {
            textCache = label.getText();
        });
    }

}
