package com.computeralchemist.consoleUI.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

public class NullAlert {

    public void nullcomponentAllert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Server is not responsing...");
        alert.setHeaderText(null);
        alert.setContentText("Server cannot return component."+
                "\n Probably productId not exist.");
        alert.showAndWait();
    }
}
