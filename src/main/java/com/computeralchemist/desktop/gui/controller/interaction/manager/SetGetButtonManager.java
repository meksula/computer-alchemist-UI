package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.set.ComputerSet;
import com.computeralchemist.desktop.gui.alerts.NoComponentAlert;
import com.computeralchemist.desktop.gui.controller.presentation.SetGetPresenter;
import com.computeralchemist.desktop.logic.command.ComputerSetRequestsCommand;
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

public class SetGetButtonManager extends PaneManager implements Initializable {
    private String requiredFxml = "parts/sets";
    private String computerSetType;
    private String productId;
    private ComputerSet computerSet;

    @FXML
    private TextField idField;

    @Override
    protected String fxmlName() {
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
    public void executeRequest(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        try {
            computerSet = new ComputerSetRequestsCommand().executeGetRequest(Arrays.asList("set", computerSetType, productId));
        } catch (RuntimeException e) {
            new NoComponentAlert().noComponent(computerSetType, productId);
        }

        new SetGetPresenter().presentResult(presenter, computerSet);
    }


}
