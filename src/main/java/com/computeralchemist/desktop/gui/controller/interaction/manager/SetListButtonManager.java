package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.set.ComputerSet;
import com.computeralchemist.desktop.gui.controller.presentation.SetListPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class SetListButtonManager extends PaneManager {
    private String requiredFxml = "parts/setsList";
    private String computerSetType;
    private ComputerSet computerSet;

    @Override
    protected String fxmlName() {
        return requiredFxml;
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        computerSetType = ((MenuItem)actionEvent.getSource()).getId();
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) {
        new SetListPresenter().presentResult(presenter, computerSet);
    }


}