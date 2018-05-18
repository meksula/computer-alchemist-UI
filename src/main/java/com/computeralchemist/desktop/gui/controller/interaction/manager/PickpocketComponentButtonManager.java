package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.gui.controller.presentation.ComponentGetPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class PickpocketComponentButtonManager extends PaneManager implements Initializable {
    private final String REQUIRED_PATH = "pickpocket/pickpocketLink";
    private String urlToParse;
    private String componentType = "cpu";

    private String hint = "At left side you see result\nof extracting data from your link."
                            + "\nIf you're not satisfied with the result\n" +
                                "edit these values yourself.\nTo do this click button bellow.";

    private ComputerComponent computerComponent;

    @FXML
    private TextField linkField;

    @Override
    protected String fxmlName() {
        return REQUIRED_PATH;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) {
        urlToParse = linkField.getText();
        guiSets();
    }

    private void guiSets() {
        new ComponentGetPresenter().presentResult(presenter, computerComponent);
        cleanControllPane();

        controllPane.getChildren().add(createHintLabel(hint));
        controllPane.getChildren().add(createEditButton("edit"));
    }

    protected static Label createHintLabel(String text) {
        Label label = new Label(text);
        label.getStyleClass().add("txt");
        return label;
    }

    protected static Button createEditButton(String edit) {
        Button button = new Button(edit);
        button.setLayoutX(50);
        button.setLayoutY(100);
        button.setOnMouseClicked(event -> goToComponentEdit());
        return button;
    }

    private static void goToComponentEdit() {
        //TODO here go to edit screen
    }

}
