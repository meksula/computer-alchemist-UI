package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class NumberExpectedAlert {

    public void popupAlert(String txt) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText(txt);
        alert.setTitle("Number expected");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
