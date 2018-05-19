package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.set.ComputerSet;
import com.computeralchemist.desktop.gui.controller.presentation.SetListPresenter;
import com.computeralchemist.desktop.logic.command.ComputerSetListRequestCommand;
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

public class SetListButtonManager extends PaneManager {
    private String requiredFxml = "parts/setsList";
    private String computerSetType;

    @Override
    protected String fxmlName() {
        return requiredFxml;
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        computerSetType = ((MenuItem)actionEvent.getSource()).getId();
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        List<ComputerSet> setList = new ComputerSetListRequestCommand().executeGetRequest(Arrays.asList("set", computerSetType));

        new SetListPresenter().presentResult(presenter, setList);
    }

}