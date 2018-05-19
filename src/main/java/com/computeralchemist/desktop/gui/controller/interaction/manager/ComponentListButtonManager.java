package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.gui.controller.presentation.ComponentListPresenter;
import com.computeralchemist.desktop.logic.command.ComponentListRequestCommand;
import com.computeralchemist.desktop.logic.command.RequestCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class ComponentListButtonManager extends PaneManager {
    private final String REQUIRED_FXML = "parts/listComponentGet";
    private RequestCommand<List<ComputerComponent>> command;
    private String componentType;
    private List<ComputerComponent> componentList;

    @Override
    protected String fxmlName() {
        return REQUIRED_FXML;
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        componentType = ((MenuItem) actionEvent.getSource()).getId();
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        command = new ComponentListRequestCommand();
        componentList = command.executeGetRequest(Arrays.asList("components", componentType));

        new ComponentListPresenter().presentResult(presenter, componentList);
    }

}
