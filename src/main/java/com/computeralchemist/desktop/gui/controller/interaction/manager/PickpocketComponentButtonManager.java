package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.creator.ComponentFactory;
import com.computeralchemist.desktop.exception.CannotReadTypeException;
import com.computeralchemist.desktop.gui.alerts.CannotReadAlert;
import com.computeralchemist.desktop.gui.alerts.PostedComponentAlert;
import com.computeralchemist.desktop.gui.alerts.TypeNotSelectedAlert;
import com.computeralchemist.desktop.gui.controller.presentation.ComponentGetPresenter;
import com.computeralchemist.desktop.gui.controller.presentation.particular.CpuLabelBinder;
import com.computeralchemist.desktop.gui.controller.presentation.particular.LabelBinder;
import com.computeralchemist.desktop.logic.command.ComponentPostRequestCommand;
import com.computeralchemist.desktop.logic.command.PickpocketRequestCommand;
import com.computeralchemist.desktop.logic.jersey.pickpocket.PickpocketLink;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class PickpocketComponentButtonManager extends PaneManager implements Initializable {
    private final String REQUIRED_PATH = "pickpocket/pickpocketLink";
    private String urlToParse;
    private String componentType;
    private static boolean editing = false;

    private String hint = "At left side you see result\nof extracting data from your link."
                            + "\nIf you're not satisfied with the result\n" +
                                "edit these values yourself.\nTo do this click button bellow.";

    private static ComputerComponent computerComponent;

    @FXML
    private TextField linkField;

    @FXML
    private Label choosen;

    @Override
    protected String fxmlName() {
        return REQUIRED_PATH;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (componentType == null || componentType.isEmpty()) {
            new TypeNotSelectedAlert().popupAlert();
            return;
        }

        urlToParse = linkField.getText();

        if (urlToParse.isEmpty())
            return;

        try {
            computerComponent = new PickpocketRequestCommand(new PickpocketLink(urlToParse))
                    .executePostPickpocketRequest(Arrays.asList("pickpocket", componentType));
        } catch (CannotReadTypeException crte) {
            new CannotReadAlert().popupAlert(urlToParse);
            return;
        }

        guiSets();
    }

    private void guiSets() {
        new ComponentGetPresenter().presentResult(presenter, computerComponent);
        cleanControllPane();

        controllPane.getChildren().add(createHintLabel(hint));
        controllPane.getChildren().add(createEditButton("edit"));
        controllPane.getChildren().add(createSaveButton("save"));
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
        button.setPrefWidth(80);
        button.setOnMouseClicked(event -> goToComponentEdit());
        return button;
    }

    private Button createSaveButton(String save) {
        Button button = new Button(save);
        button.setLayoutX(50);
        button.setLayoutY(130);
        button.setPrefWidth(80);
        button.setOnMouseClicked(event -> saveComponent());
        return button;
    }

    private void saveComponent() {
        if (editing) {
            LabelBinder binder = ComponentGetPresenter.labelBinder;
            computerComponent = binder.updateValues();
        }

        String status = new ComponentPostRequestCommand(computerComponent).executePostRequest(Arrays.asList("components"));
        new PostedComponentAlert().popupAlert(status);
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        this.componentType = ((MenuItem)actionEvent.getSource()).getId();
        this.choosen.setText(componentType);
    }

    private static void goToComponentEdit() {
        editing = true;
        ComponentGetPresenter.addModificationable();

        controllPane.getChildren().add(createEditLabel());
    }

    private static Label createEditLabel() {
        Label label = new Label();
        label.setText("! EDIT MODE. Now, after mouse click at value\n,you can change the value of chosen field.");
        label.getStyleClass().add("empty");
        label.setLayoutX(5);
        label.setLayoutY(200);
        return label;
    }

}
