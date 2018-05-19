package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 19-05-2018
 * */

public class NoComponentAlert {

    public void noComponent(String type, String id) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No component");
        alert.setHeaderText(null);
        alert.setContentText("There is no " + type + " with productId: " + id + " in database.");
        alert.showAndWait();
    }
}
