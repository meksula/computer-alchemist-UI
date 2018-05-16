package com.computeralchemist.desktop.gui.controller.interaction.manager;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public abstract class PaneManager {
    AnchorPane anchorPane;
    static Pane controllPane;
    static Pane presenter;

    protected abstract String fxmlName();

    public final void arrangePane(Parent parent) {
        this.anchorPane = (AnchorPane) parent;
        presenter = (Pane) anchorPane.getChildren().get(2);
        controllPane = (Pane) anchorPane.getChildren().get(3);

        loadFXML();
    }

    void loadFXML() {
        cleanControllPane();
        cleanPresenterPane();

        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/templates/" + fxmlName() + ".fxml"));

        Pane pane = null;

        try {
            pane = fxmlLoader.load();
        } catch (IOException e) {
            System.out.println("Cannot load FXML template.");
        }

        controllPane.getChildren().add(pane);
    }

    void cleanControllPane() {
        controllPane.getChildren().clear();
    }

    void cleanPresenterPane() {
        presenter.getChildren().clear();
    }

}
