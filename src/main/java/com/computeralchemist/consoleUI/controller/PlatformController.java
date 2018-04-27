package com.computeralchemist.consoleUI.controller;

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
    private MenuItem getComponentButton, getComponentListButton, getSetButton, getSetListButton;

    private UIManager uiManager;

    @FXML
    void showUserPanel(ActionEvent event) throws IOException {
        controllPane.setVisible(true);
        clearPane(controllPane);

        if (event.getSource() == getComponentButton) {
            clearPane(controllPane);
            uiManager = new ComponentUI();
            uiManager.arrangePane(controllPane);
        }

        else if (event.getSource() == getComponentListButton) {
            clearPane(controllPane);
            uiManager = new ListOfComponentsUI();
            uiManager.arrangePane(controllPane);
        }

        else if (event.getSource() == getSetButton) {
            clearPane(controllPane);
            uiManager = new SetUI();
            uiManager.arrangePane(controllPane);
        }

        else if (event.getSource() == getSetListButton) {
            clearPane(controllPane);
            uiManager = new ListOfSetsUI();
            uiManager.arrangePane(controllPane);
        }

    }

    private void clearPane(Pane pane) {
        pane.getChildren().clear();
    }

}
