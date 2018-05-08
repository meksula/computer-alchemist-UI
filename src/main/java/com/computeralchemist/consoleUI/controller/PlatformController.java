package com.computeralchemist.consoleUI.controller;

import com.computeralchemist.consoleUI.gui.dataPresentation.DataPresenter;
import com.computeralchemist.consoleUI.gui.ui.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 24-04-2018
 * */

public class PlatformController {

    @FXML
    public Pane presenter;

    @FXML
    public Pane controllPane;

    @FXML
    private MenuItem postComponent;

    @FXML
    private MenuItem getComponentButton, getComponentListButton, getSetButton, getSetListButton;

    private UIManager uiManager;

    @FXML
    void showUserPanel(ActionEvent event) throws IOException {
        controllPane.setVisible(true);
        clearPane(controllPane);

        if (event.getSource() == getComponentButton)
            uiManager = new ComponentUI();

        else if (event.getSource() == getComponentListButton)
            uiManager = new ListOfComponentsUI();

        else if (event.getSource() == getSetButton)
            uiManager = new SetUI();

        else if (event.getSource() == getSetListButton)
            uiManager = new ListOfSetsUI();


        uiManager.arrangePane(controllPane);
        DataPresenter.setPresenter(presenter);
    }

    private void clearPane(Pane pane) {
        pane.getChildren().clear();
    }

    @FXML
    public void postComponent(ActionEvent actionEvent) throws IOException {
        clearPane(controllPane);
        clearPane(presenter);

        uiManager = new PostComponentUI();
        uiManager.arrangePane(controllPane);
    }
}
