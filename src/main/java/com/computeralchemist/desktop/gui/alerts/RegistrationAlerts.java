package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 09-06-2018
 * */

public class RegistrationAlerts {

    public RegistrationAlerts(String httpStatus) {
        if (httpStatus.equals("200") || httpStatus.equals("201"))
            registered();

        else if (httpStatus.startsWith("3") || httpStatus.startsWith("4"))
            badRequest();

        else serverNotResponding();
    }

    private void badRequest() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Bad request: some of data is wrong");
        alert.setHeaderText(null);
        alert.setContentText("Something went wrong. Check out your entered data and execute again.");
        alert.showAndWait();
    }

    private void registered() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registered");
        alert.setHeaderText(null);
        alert.setContentText("Congratulations. You are registered.");
        alert.showAndWait();
    }

    private void serverNotResponding() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Server panic...");
        alert.setHeaderText(null);
        alert.setContentText("Unfortunatelly something is wrong with server.\nWe are working at this.");
        alert.showAndWait();
    }

}
