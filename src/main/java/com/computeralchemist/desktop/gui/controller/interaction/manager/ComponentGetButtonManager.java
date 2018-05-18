package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.gui.controller.presentation.ComponentGetPresenter;
import com.computeralchemist.desktop.logic.command.ComponentRequestsCommand;
import com.computeralchemist.desktop.logic.command.RequestCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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
    private RequestCommand<ComputerComponent> requestCommand;
    private ComputerComponent computerComponent;

    @FXML
    private TextField idField;

    @Override
    protected String fxmlName() {
        return REQUIRED_FXML;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idField.setOnKeyReleased(field -> this.productId = field.getText());

        requestCommand = new ComponentRequestsCommand<>();
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        componentType = ((MenuItem)actionEvent.getSource()).getId().trim();
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        request();

        new ComponentGetPresenter().presentResult(presenter, computerComponent);
    }

    private void request() throws IOException, ClassNotFoundException {
        computerComponent = requestCommand.executeGetRequest(Arrays.asList("components", componentType, productId));
    }


}
