package com.computeralchemist.consoleUI.gui.dataPresentation;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.consoleUI.controller.PresenterPanelController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public class DataPresenter {
    public static Pane presenter;
    private PresenterPanelController presenterPanelController;
    private ComputerComponent computerComponent;
    private String resourceUri;

    public void setComputerComponent(ComputerComponent computerComponent) {
        this.computerComponent = computerComponent;
    }

    public static void setPresenter(Pane presenter) {
        DataPresenter.presenter = presenter;
    }

    public void setResourceUri(String resourceUri) {
        this.resourceUri = resourceUri;
    }

    public void presentComponent() {
        presenter.getChildren().clear();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(resourceUri));

        try {
            Pane pane = loader.load();
            presenter.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }

        presenterPanelController = loader.getController();
        presenterPanelController.displayObjectData(computerComponent);
    }

}
