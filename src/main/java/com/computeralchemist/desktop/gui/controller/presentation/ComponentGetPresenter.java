package com.computeralchemist.desktop.gui.controller.presentation;

import javafx.event.ActionEvent;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public class ComponentGetPresenter extends ResultPresenter {

    @Override
    protected String setFxmlPath() {
        return "/templates/parts/components/" + fxmlName + ".fxml";
    }

    public void editComponent(ActionEvent actionEvent) {
        //TODO
    }
}
