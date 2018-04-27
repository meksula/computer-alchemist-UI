package com.computeralchemist.consoleUI.gui.ui;

import com.computeralchemist.consoleUI.api.ComponentDataProvider;
import com.computeralchemist.consoleUI.components.ComputerComponent;
import com.computeralchemist.consoleUI.gui.dataPresentation.CpuDataPresenter;
import com.computeralchemist.consoleUI.gui.dataPresentation.DataPresenter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 27-04-2018
 * */

public class ComponentUI extends UIManager implements Initializable {
    @FXML
    private TextField idField;
    private Pane pane;
    private String componentType;
    private String productId;
    private ArrayList<String> pathElements;

    public ComponentUI() {
        this.dataProvider = new ComponentDataProvider(pathElements);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idField.setOnKeyReleased(field -> this.productId = field.getText());
    }

    @Override
    public void arrangePane(Pane pane) {
        this.pane = pane;

        try {
            loadUiPane();
        } catch (IOException e) {
            System.out.println("Cannot parse template!");
        }
    }

    public void loadUiPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass()
                .getResource("/templates/parts/pane.fxml"));
        Pane ui = loader.load();

        pane.getChildren().addAll(ui);
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        ComputerComponent computerComponent = dataProvider.getComponent();
        selectPresenter(computerComponent);
    }

    private void selectPresenter(ComputerComponent computerComponent) {
        presenterFactory.createGuiPresenter(computerComponent).presentComponent();
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        this.componentType = getType(actionEvent.getSource().toString());
    }

    private void initList() {
        pathElements = new ArrayList<>();
        pathElements.add(componentType);
        pathElements.add(productId);
    }

}
