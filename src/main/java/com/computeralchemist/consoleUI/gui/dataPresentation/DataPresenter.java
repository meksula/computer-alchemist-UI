package com.computeralchemist.consoleUI.gui.dataPresentation;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public abstract class DataPresenter {
    protected ComputerComponent computerComponent;

    public DataPresenter(ComputerComponent computerComponent) {
        this.computerComponent = computerComponent;
    }

    public abstract void presentComponent();

    Label createLabel(String text) {
        Label label = new Label();
        label.setText(text);
        label.setTextFill(Color.WHITE);
        return label;
    }
}
