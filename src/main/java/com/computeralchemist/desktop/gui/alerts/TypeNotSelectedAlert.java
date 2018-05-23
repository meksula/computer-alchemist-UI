package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 23-05-2018
 * */

public class TypeNotSelectedAlert {

    public void popupAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Select type");
        alert.setHeaderText(null);
        alert.setContentText("Please select component type.");
        alert.showAndWait();
    }
}
