package com.computeralchemist.consoleUI.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 08-05-2018
 * */

public class InputErrorAlert {

    public void numberExpected(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Number expected!");
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    public void formNotComplete() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Form not complete");
        alert.setContentText("One or more field in form is empty!");
        alert.showAndWait();
    }
}
