package com.computeralchemist.desktop.gui.controller.interaction.manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;


/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class ComponentPostButtonManager extends PaneManager {
    private String requiredFxml = "post/postComponent";
    private String componentType;

    @Override
    protected String fxmlName() {
        return requiredFxml;
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        componentType = ((MenuItem) actionEvent.getSource()).getId();
        setConcreteComponent();
    }

    private void setConcreteComponent() {
        requiredFxml = "post/" + componentType;
        loadFXML();
    }

}
