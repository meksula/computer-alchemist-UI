package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 18-05-2018
 * */

public class LoginAlerts {

    public void accessDenied() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Access denied");
        alert.setHeaderText(null);
        alert.setContentText("Login or password is incorrect\nPlease check these again.");
        alert.showAndWait();
    }

    public void serverNotResponse() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Server not responsing...");
        alert.setHeaderText(null);
        alert.setContentText("Sorry... Probably server has died.");
        alert.showAndWait();
    }

}
