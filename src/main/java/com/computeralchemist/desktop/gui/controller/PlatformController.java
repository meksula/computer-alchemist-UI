package com.computeralchemist.desktop.gui.controller;

import com.computeralchemist.desktop.exception.CannotReadTypeException;
import com.computeralchemist.desktop.gui.controller.interaction.ManagerFactory;
import com.computeralchemist.desktop.gui.controller.interaction.UIManagerFactory;
import com.computeralchemist.desktop.gui.controller.interaction.manager.PaneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 24-04-2018
 * */

public class PlatformController implements Initializable {

    @FXML
    private Pane presenter;

    @FXML
    private Pane controllPane;

    @FXML
    private AnchorPane canvas;

    private ManagerFactory factory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        factory = new UIManagerFactory();
    }

    @FXML
    void showUserPanel(ActionEvent event) {
        String buttonPushed = getType(event.getSource().toString());
        PaneManager paneManager = factory.createManager(buttonPushed);
        paneManager.arrangePane(canvas);
    }

    public static String getType(String source) {
        Pattern pattern = Pattern.compile("=[a-zA-Z]{3,},");
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            String result = matcher.group();
            return result.substring(1, result.length() - 1);
        }

        throw new CannotReadTypeException(source);
    }

}
