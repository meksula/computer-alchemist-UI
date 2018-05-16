package com.computeralchemist.desktop.gui.controller.presentation.nodes;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksula
 * 16-05-2018
 * */

public abstract class LabelFactory {

    public Label createLabel(String text) {
        String baseColor = "#efe3ee";

        Label label = new Label(text);
        label.setTextFill(Paint.valueOf(baseColor));

        label.setOnMouseEntered(event -> {
            label.setTextFill(Color.YELLOW);
        });

        label.setOnMouseExited(event -> {
            label.setTextFill(Paint.valueOf(baseColor));
        });

        label.setOnMouseClicked(event -> {
            String txt = label.getText();
            String model = extractModel(txt);
            presentIndicatedComponent(model);
        });

        return label;
    }

    protected abstract void presentIndicatedComponent(String model);

    private String extractModel(String txt) {
        Pattern pattern = Pattern.compile(",\\s.+,");
        Matcher matcher = pattern.matcher(txt);

        String result = "";
        if (matcher.find())
            result = matcher.group();

        return result.substring(1, result.length() - 1).trim();
    }
}
