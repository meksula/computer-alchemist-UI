package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class FormNotCompletedAlert {

    public void popupAlert(String txt) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(txt);
        alert.setTitle("Form not completed");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
