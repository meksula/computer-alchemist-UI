package com.computeralchemist.desktop.gui.controller;

import com.computeralchemist.desktop.gui.alerts.LoginAlerts;
import com.computeralchemist.desktop.logic.jersey.AuthenticationApi;
import com.computeralchemist.desktop.logic.jersey.DefaultAuthentication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 24-04-2018
 * */

public class WelcomeController implements Initializable {
    private DefaultAuthentication authentication;
    private int httpStatus;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        authentication = DefaultAuthentication.getInstance();
    }

    @FXML
    public void goRegisterScreen(MouseEvent event) {
        //TODO after spring security implementation, add this
    }

    @FXML
    public void login(ActionEvent event) throws IOException {
        boolean access = false;

        try {
            access = tryLogin();
        } catch (RuntimeException e) {
            new LoginAlerts().serverNotResponse();
        }

        if (access) {
            Parent parent = FXMLLoader.load(this.getClass().getResource("/templates/platform.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

        else if (httpStatus == 401)
            new LoginAlerts().accessDenied();

    }

    private boolean tryLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        httpStatus = authentication.login(username, password);

        return httpStatus == 200;
    }

}

