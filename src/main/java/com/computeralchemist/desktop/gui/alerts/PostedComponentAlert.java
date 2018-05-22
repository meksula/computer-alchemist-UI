package com.computeralchemist.desktop.gui.alerts;

import javafx.scene.control.Alert;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class PostedComponentAlert {

    public void popupAlert(String httpStatus) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("POST process");
        alert.setHeaderText(null);

        if (httpStatus.equals("201"))
            alert.setContentText("Component correctly posted and saved in database.");

        else alert.setContentText("Unfortunatelly something went wrong and component hasn'n been posted.");

        alert.showAndWait();
    }
}
