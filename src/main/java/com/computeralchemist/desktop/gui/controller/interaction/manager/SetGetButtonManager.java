package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.gui.controller.presentation.SetGetPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class SetGetButtonManager extends PaneManager implements Initializable {
    private String requiredFxml = "parts/sets";
    private String computerSetType;
    private String productId;

    @FXML
    private TextField idField;

    @Override
    String fxmlName() {
        return requiredFxml;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idField.setOnKeyReleased(field -> this.productId = field.getText());
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        computerSetType = ((MenuItem)actionEvent.getSource()).getId();
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) {
        new SetGetPresenter().presentResult(presenter, computerSetType);
    }


}
