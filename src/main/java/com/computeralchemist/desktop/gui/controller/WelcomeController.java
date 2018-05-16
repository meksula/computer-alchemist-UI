package com.computeralchemist.desktop.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

/**
 * @Author
 * Karol Meksuła
 * 24-04-2018
 * */

public class WelcomeController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Label registerButton;

    @FXML
    void goRegisterScreen(MouseEvent event) {
        //TODO after spring security implementation, add this
    }

    @FXML
    void login(ActionEvent event) throws IOException {
        //TODO after spring security implementation, add this

        Parent parent = FXMLLoader.load(this.getClass().getResource("/templates/platform.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}

