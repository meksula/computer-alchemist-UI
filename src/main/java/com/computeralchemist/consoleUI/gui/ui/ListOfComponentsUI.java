package com.computeralchemist.consoleUI.gui.ui;

import com.computeralchemist.consoleUI.api.UriExecute;
import com.computeralchemist.consoleUI.api.UriExecutor;
import com.computeralchemist.consoleUI.components.ComputerComponent;
import com.computeralchemist.consoleUI.gui.dataPresentation.DataPresenter;
import com.computeralchemist.consoleUI.mapping.ComponentJsonMapper;
import com.computeralchemist.consoleUI.mapping.JsonMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author
 * Karol Meksuła
 * 27-04-2018
 * */

public class ListOfComponentsUI extends UIManager implements Initializable {
    private Pane pane;
    private String componentType;
    private String amount;
    private UriExecute uriExecutor;
    private JsonMapper jsonMapper;

    @FXML
    private TextField idField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idField.setOnKeyReleased(field -> this.amount = field.getText());
        uriExecutor = new UriExecutor();
        jsonMapper = new ComponentJsonMapper();
    }

    @Override
    public void arrangePane(Pane pane) {
        this.pane = pane;

        try {
            loadUiPane();
        } catch (IOException ioe) {
            System.out.println("Cannot load .fxml");
        }
    }

    private void loadUiPane() throws IOException{
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/templates/parts/listComponentGet.fxml"));
        Pane pane = loader.load();

        this.pane.getChildren().add(pane);
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        this.componentType = getType(actionEvent.getSource().toString());
        System.out.println(componentType);
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) throws IOException {
        uriExecutor.setAbsolutePath("http://localhost:8080/components/" + componentType);

        String json = uriExecutor.execute();

        List<ComputerComponent> componentList = jsonMapper.listOfComponents(json, componentType);

        showPresenter(componentList);
    }

    private void showPresenter(List<ComputerComponent> components) throws IOException {
        Pane paneData = new Pane();
        VBox vBox = new VBox();
        paneData.getChildren().add(vBox);

        AtomicInteger counter = new AtomicInteger();
        components.forEach(component -> {
            counter.getAndIncrement();
            vBox.getChildren().add(createLabel(counter + ": " + component.getProducent() + ", " + component.getModel() +
            ", RATE: " + component.getRatesEvg()));
        });

        DataPresenter.presenter.getChildren().clear();
        DataPresenter.presenter.getChildren().add(paneData);
    }

    private Label createLabel(String text) {
        Label label = new Label();
        label.setTextFill(Color.WHITE);
        label.setText(text);

        label.setOnMouseEntered(event -> {
            label.setTextFill(Color.YELLOW);
        });
        label.setOnMouseExited(event -> {
            label.setTextFill(Color.WHITE);
        });

        label.setOnMouseClicked(event -> {

        });

        return label;
    }

}
