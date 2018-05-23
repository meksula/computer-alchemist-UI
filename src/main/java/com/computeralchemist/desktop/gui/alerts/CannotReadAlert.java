package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 23-05-2018
 * */

public class CannotReadAlert {

    public void popupAlert(String link) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Sorry, but Pickpocket cannot steal data from link\n" + link);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

}
