package com.computeralchemist.consoleUI.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public class PickpocketUiManager {
    private Pane controllPane;
    private String producedComponentType;
    private PickpocketUiManager pickpocketUiManager;
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/templates/pickpocket/pickpocketLink.fxml"));

    private void loadViewTemplate() {
        controllPane.getChildren().clear();

        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            System.out.println("Cannot load FXML template.");
        }

        if (pane != null) {
            controllPane.getChildren().add(pane);
            controllPane.setLayoutX(0);
        }

        pickpocketUiManager = loader.getController();
    }




    public void executeRequest(ActionEvent actionEvent) {
        //loadResultView();
    }

    private void loadResultView() {
        pickpocketUiManager.controllPane.getChildren().clear();
        /*FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/templates/parts/components/cpu.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            System.out.println("Cannot load FXML template.");
        }

        if (pane != null) {
            controllPane.getChildren().add(pane);
            controllPane.setLayoutX(0);
        }*/
    }


}
