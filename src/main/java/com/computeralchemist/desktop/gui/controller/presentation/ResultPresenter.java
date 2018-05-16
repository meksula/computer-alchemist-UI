package com.computeralchemist.desktop.gui.controller.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public abstract class ResultPresenter {
    protected static Pane presenter;
    protected String fxmlName;
    protected String fxmlPath;

    public final void presentResult(Parent parent, String fxmlName) {
        presenter = (Pane) parent;
        this.fxmlName = fxmlName;

        fxmlPath = setFxmlPath();
        loadPresenter();
    }

    //this method sets initial value of path to load
    protected abstract String setFxmlPath();

    //this method is use to load other path when application is running
    protected void setFxmlPath(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    protected void loadPresenter() {
        FXMLLoader loader =
                new FXMLLoader(this.getClass().getResource(fxmlPath));

        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            System.out.println("Cannot load FXML template.");
        }

        presenter.getChildren().add(pane);
    }

}
