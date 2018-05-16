package com.computeralchemist.consoleUI.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public class CloseConfirmation {

    public void closeConfirmAlert() throws RuntimeException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Closing...");
        alert.setHeaderText("Are you sure to close application?");
        alert.setContentText(null);

        Optional<ButtonType> button = alert.showAndWait();
        if (button.get() == ButtonType.OK) {

        }

        else if (button.get() == ButtonType.CANCEL) {
            throw new RuntimeException();
        }


    }
}
