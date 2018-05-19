package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 19-05-2018
 * */

public class SetNotComplete {

    public void setNotComplete() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Set not complete");
        alert.setHeaderText(null);
        alert.setContentText("Notice that set can be unfinished.");
        alert.showAndWait();
    }
}
