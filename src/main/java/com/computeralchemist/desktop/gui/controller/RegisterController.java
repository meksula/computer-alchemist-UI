package com.computeralchemist.desktop.gui.controller;

import com.computeralchemist.desktop.gui.alerts.RegistrationAlerts;
import com.computeralchemist.desktop.logic.jersey.DefaultRegistrationApi;
import com.computeralchemist.desktop.logic.jersey.RegistrationApi;
import com.computeralchemist.desktop.logic.jersey.RegistrationForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * @Author
 * Karol Meksuła
 * 09-06-2018
 * */

public class RegisterController {
    private RegistrationApi registrationApi;

    @FXML
    private TextField username, name, surname, email, password, bornyear;

    public RegisterController() {
        this.registrationApi = DefaultRegistrationApi.getDefaultRegistrationApi();
    }

    @FXML
    public void executeRegister(ActionEvent event) {
        RegistrationForm form = new RegistrationForm.FormBuilder()
                .username(username.getText())
                .name(name.getText())
                .surname(surname.getText())
                .email(email.getText())
                .password(password.getText())
                .bornyear(bornyear.getText())
                .address(null)
                .build();

        String result = registrationApi.registerUser(form);

        new RegistrationAlerts(result);
    }

}
