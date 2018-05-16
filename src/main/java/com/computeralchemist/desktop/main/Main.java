package com.computeralchemist.desktop.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @Author
 * Karol Meksuła
 * 24-04-2018
 * */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass()
                .getResource("/templates/welcome.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        scene.getStylesheets().add("styles.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("Computer Alchemist UI admin console");

        primaryStage.setOnCloseRequest(handler -> {

        });

        primaryStage.show();
    }

    public static void main(String[]args) {
        launch(args);
    }
}