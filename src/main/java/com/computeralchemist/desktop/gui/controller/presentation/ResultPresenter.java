package com.computeralchemist.desktop.gui.controller.presentation;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.set.ComputerSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public abstract class ResultPresenter {
    protected static Pane presenter;
    protected static String fxmlName;
    protected String fxmlPath;
    protected static ComputerComponent computerComponent;
    protected static ComputerSet computerSet;
    protected static List<ComputerComponent> componentList;
    protected static List<ComputerSet> setList;
    protected static List<String> properties;

    public final void presentResult(Parent parent, ComputerComponent computerComponent) {
        ResultPresenter.presenter = (Pane) parent;
        ResultPresenter.computerComponent = computerComponent;
        fxmlName = computerComponent.getComponentType();
        fxmlPath = setFxmlPath();

        loadPresenter();
    }

    public final void presentResult(Parent parent, ComputerSet computerSet) {
        ResultPresenter.presenter = (Pane) parent;
        fxmlName = computerSet.getType().toString();
        ResultPresenter.computerSet = computerSet;

        fxmlPath = setFxmlPath();
        loadPresenter();
    }

    public void presentResult(Parent parent, List<?> list) {
        ResultPresenter.presenter = (Pane) parent;
        ResultPresenter.componentList = (List<ComputerComponent>) list;

        fxmlPath = setFxmlPath();
        loadPresenter();
    }

    public void presentResultProperties(Parent parent, List<String> list) {
        ResultPresenter.presenter = (Pane) parent;
        ResultPresenter.properties = list;

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
            e.printStackTrace();
            System.out.println("Cannot load FXML template.");
        }

        if (presenter != null && pane != null)
            presenter.getChildren().add(pane);
    }

}
