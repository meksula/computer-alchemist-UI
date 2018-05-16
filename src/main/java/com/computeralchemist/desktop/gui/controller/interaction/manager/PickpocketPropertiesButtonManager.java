package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import com.computeralchemist.consoleUI.components.cpu.Cpu;
import com.computeralchemist.desktop.gui.controller.presentation.ComponentGetPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static com.computeralchemist.desktop.gui.controller.interaction.manager.PickpocketComponentButtonManager.createHintLabel;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class PickpocketPropertiesButtonManager extends PaneManager {
    private String fxmlPath = "pickpocket/pickpocketLinkProperties";
    private String hint = "In the left side of screen you\nsee extracted values from url." +
            "\nIf you want to build Component,\n" +
            "click link bellow: (The process may be unsuccessful)";
    private ComputerComponent builded;

    @FXML
    private TextField linkField;

    @Override
    protected String fxmlName() {
        return fxmlPath;
    }

    public void executeRequest(ActionEvent actionEvent) {
        cleanControllPane();

        controllPane.getChildren().add(createHintLabel(hint));
        controllPane.getChildren().add(createEditButton("Build component"));
    }

    private Button createEditButton(String text) {
        Button button = new Button(text);
        button.setLayoutX(50);
        button.setLayoutY(80);
        button.setOnMouseClicked(event -> {
            builded = componentBuild();
            presentBuilded();
        });

        return button;
    }

    private ComputerComponent componentBuild() {
        return new Cpu(); //TODO ta metoda, ma budować komponent oraz go prezentować.
    }

    private void presentBuilded() {
        //TODO ta metoda zaprezentuje zbudowany komponent
        //PS: wszystko działa poprawnie ;)
        new ComponentGetPresenter().presentResult(presenter, builded.getComponentType());
    }
}
