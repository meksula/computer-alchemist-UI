package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.gui.controller.presentation.ComponentListPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class ComponentListButtonManager extends PaneManager {
    private final String REQUIRED_FXML = "parts/listComponentGet";
    private String componentType;
    private ComputerComponent computerComponent;

    @Override
    protected String fxmlName() {
        return REQUIRED_FXML;
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        componentType = ((MenuItem) actionEvent.getSource()).getId();
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) {
        new ComponentListPresenter().presentResult(presenter, computerComponent);
    }

}
