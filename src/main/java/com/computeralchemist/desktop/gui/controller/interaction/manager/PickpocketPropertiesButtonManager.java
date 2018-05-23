package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.gui.alerts.TypeNotSelectedAlert;
import com.computeralchemist.desktop.gui.controller.presentation.ComponentGetPresenter;
import com.computeralchemist.desktop.gui.controller.presentation.PickpocketPropertiesPresenter;
import com.computeralchemist.desktop.logic.command.PickpocketPropertiesRequestsCommand;
import com.computeralchemist.desktop.logic.jersey.pickpocket.PickpocketLink;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.computeralchemist.desktop.gui.controller.interaction.manager.PickpocketComponentButtonManager.createHintLabel;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class PickpocketPropertiesButtonManager extends PaneManager {
    private String fxmlPath = "pickpocket/pickpocketLinkProperties";
    private String hint = "In the right side of screen\nyou see extracted values from url." +
            "\nIf you want to build Component,\n" +
            "click link bellow: (The process may be unsuccessful)";

    private List<String> properties;
    private ComputerComponent builded;
    private String componentType;

    @FXML
    private Label choosen;

    @FXML
    private TextField linkField;

    @Override
    protected String fxmlName() {
        return fxmlPath;
    }

    public void executeRequest(ActionEvent actionEvent) throws IOException {
        if (componentType == null || componentType.isEmpty()) {
            new TypeNotSelectedAlert().popupAlert();
            return;
        }

        drawNodes();

        this.properties = new PickpocketPropertiesRequestsCommand(new PickpocketLink(linkField.getText()))
                .executeRequest(Arrays.asList("pickpocket", componentType, "properties"));

        new PickpocketPropertiesPresenter().presentResultProperties(presenter, properties);
    }

    private void drawNodes() {
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
        new ComponentGetPresenter().presentResult(presenter, builded);
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        this.componentType = ((MenuItem)actionEvent.getSource()).getId();
        this.choosen.setText(componentType);
    }
}
