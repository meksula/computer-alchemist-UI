package com.computeralchemist.consoleUI.gui.ui;

import com.computeralchemist.consoleUI.alerts.NullAlert;
import com.computeralchemist.consoleUI.api.ComponentDataProvider;
import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.consoleUI.gui.dataPresentation.PresenterFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

    private void loadUiPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass()
                .getResource("/templates/parts/componentGet.fxml"));
        Pane ui = loader.load();

        pane.getChildren().addAll(ui);
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        initDataProvider();
        ComputerComponent computerComponent;
        try {
            computerComponent = dataProvider.getComponent();
        } catch (RuntimeException e) {
            new NullAlert().nullcomponentAllert();
            return;
        }

        selectPresenter(computerComponent);
    }

    private void selectPresenter(ComputerComponent computerComponent) {
        new PresenterFactory()
                .createGuiPresenter(computerComponent)
                .presentComponent();
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        this.componentType = getType(actionEvent.getSource().toString());
    }

    private void initDataProvider() {
        String[] elements = {componentType, productId};
        dataProvider = new ComponentDataProvider(Arrays.asList(elements));
    }

}
