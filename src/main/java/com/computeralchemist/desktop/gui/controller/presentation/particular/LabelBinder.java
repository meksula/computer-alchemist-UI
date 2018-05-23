package com.computeralchemist.desktop.gui.controller.presentation.particular;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public abstract class LabelBinder {
    public abstract void bindWithLabel(ComputerComponent computerComponent, List<Label> labelList);

    protected void addActionAndTooltip(Label label, List<String> values) {
        Tooltip tooltip = new Tooltip();
        tooltip.setText("Click at value,\nto look next.");
        label.setTooltip(tooltip);

        AtomicInteger counter = new AtomicInteger(0);
        label.setText(values.get(counter.get()));
        label.setOnMouseClicked(event -> {
            counter.incrementAndGet();

            if (counter.get() > (values.size() - 1))
                counter.set(0);

            label.setText(values.get(counter.get()));
        });
    }

    public abstract ComputerComponent updateValues();
}
