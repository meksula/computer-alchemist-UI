package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.gui.controller.presentation.ComponentGetPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class ComponentGetButtonManager extends PaneManager implements Initializable {
    private final String REQUIRED_FXML = "parts/componentGet";
    private String componentType;
    private String productId;

    @FXML
    private TextField idField;

    @Override
    protected String fxmlName() {
        return REQUIRED_FXML;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idField.setOnKeyReleased(field -> this.productId = field.getText());
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        componentType = ((MenuItem)actionEvent.getSource()).getId().trim();
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) {
        new ComponentGetPresenter().presentResult(presenter, componentType);
    }

}
