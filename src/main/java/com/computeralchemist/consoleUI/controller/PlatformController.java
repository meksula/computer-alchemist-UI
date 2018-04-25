package com.computeralchemist.consoleUI.controller;

import com.computeralchemist.consoleUI.alerts.NullAlert;
import com.computeralchemist.consoleUI.api.UriCreator;
import com.computeralchemist.consoleUI.api.UriExecutor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 24-04-2018
 * */

public class PlatformController implements Initializable {

    @FXML
    private AnchorPane canvas;

    @FXML
    private MenuItem getComponentButton;

    @FXML
    private Pane presenter;

    @FXML
    private Pane oneComponentGet;

    @FXML
    private Button execute;

    @FXML
    private Label typeLabel;

    @FXML
    private Label productIdLabel;

    @FXML
    private MenuItem motherboard;

    @FXML
    private MenuItem cpu;

    @FXML
    private MenuItem ram;

    @FXML
    private MenuItem disk;

    @FXML
    private MenuItem supply;

    @FXML
    private MenuItem compCase;

    @FXML
    private MenuItem graphicsCard;

    @FXML
    private TextField productIdField;

    private String path;
    private String productId;

    @FXML
    void executeRequest(ActionEvent event) {
        if (componentType == null || productId == null)
            new NullAlert().popupAllert();

        String uri = UriCreator.getUriCreator().prepareUri(path, componentType, productId);
        UriExecutor uriExecutor = new UriExecutor(uri);
        uriExecutor.execute();
    }

    @FXML
    void showOneComponentGet(ActionEvent event) {
        this.oneComponentGet.setVisible(true);
    }

    private String componentType;

    public void chooseComponent(ActionEvent actionEvent) {
        if (actionEvent.getSource() == cpu)
            this.componentType = "cpu";

        this.path = "components";
        updateLabelType();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productIdField.setOnKeyReleased(event -> {
            updateLabelId();
        });
    }

    private void updateLabelId() {
        productId = productIdField.getText();
        this.productIdLabel.setText(String.valueOf(productId));
    }

    private void updateLabelType() {
        this.typeLabel.setText(componentType);
    }
}
