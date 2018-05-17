package com.computeralchemist.consoleUI.gui.ui;

import com.computeralchemist.consoleUI.alerts.InputErrorAlert;
import com.computeralchemist.consoleUI.alerts.ObjectPostedAlert;
import com.computeralchemist.consoleUI.api.post.PostComputerComponent;
import com.computeralchemist.consoleUI.api.post.PostObject;
import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.consoleUI.exception.FormNotCompleteException;
import com.computeralchemist.consoleUI.exception.InvalidInputException;
import com.computeralchemist.consoleUI.gui.ui.factory.ComponentFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @Author
 * Karol Meksuła
 * 30-04-2018
 * */

public class PostComponentUI extends UIManager implements Initializable {
    private static String typeTemp;
    private Pane pane;
    private Map<String, String> properties;
    private ComponentFactory componentFactory;
    private ComputerComponent computerComponent;
    private PostObject postObject;

    @FXML
    private TextField producent,model, cores, series, socket, threads, bitArchitecture, cache, frequency;

    @FXML
    private TextArea description;

    private List<TextInputControl> fieldList;

    public PostComponentUI() {
        postObject = new PostComputerComponent();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fieldList = new ArrayList<>();
        fieldList.addAll(Arrays.asList(producent, model, description, cores, series,
                socket, threads, bitArchitecture, cache, frequency));
    }

    @Override
    public void arrangePane(Pane pane) throws IOException {
        this.pane = pane;
        pane.getChildren().add(drawMenu());

    }

    private MenuButton drawMenu() {
        MenuButton menuButton = new MenuButton("Choose component");

        menuButton.getItems().addAll(createMenuItem("cpu"),
                                     createMenuItem("motherboard"),
                                     createMenuItem("ram"),
                                     createMenuItem("disk"),
                                     createMenuItem("supply"),
                                     createMenuItem("computercase"),
                                     createMenuItem("gpu"));

        return menuButton;
    }

    private MenuItem createMenuItem(String text) {
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(event -> {
            typeTemp = menuItem.getText();
            drawEquivalentForm();
        });

        return menuItem;
    }

    private void drawEquivalentForm() {
        pane.getChildren().clear();

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/templates/post/" + typeTemp + ".fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            System.out.println("Cannot load FXML!");
        }

        this.pane.getChildren().add(pane);
    }

    private void initFactory() {
        componentFactory = ComponentFactory.FactoryType.valueOf(typeTemp.toUpperCase().trim()).chooseFactory();
    }

    private void initProperties() {
        properties = new LinkedHashMap<>();

        for (int i = 0; i < fieldList.size(); i++) {
            if (!fieldList.get(i).getText().isEmpty()) {
                String key = fieldList.get(i).getId();
                String value = fieldList.get(i).getText();

                properties.put(key, value);
            }
        }
    }

    private void initComponent() {
        if (componentFactory != null)
            computerComponent = componentFactory.createComponent(properties);
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) {
        initProperties();
        initFactory();

        try {
            initComponent();
        } catch (FormNotCompleteException fnce) {
            new InputErrorAlert().formNotComplete();
            return;
        } catch (InvalidInputException iie) {
            new InputErrorAlert().numberExpected(iie.getMessage());
        }

        MultivaluedMap<String, String> response = postComponent();

        new ObjectPostedAlert().postAlert(response);
    }

    private MultivaluedMap<String, String> postComponent() {
        final String COMPONENT_NEW = "http://localhost:8080/components";
        postObject.setUri(COMPONENT_NEW);
        postObject.setObject(this.computerComponent);
        return postObject.executePostRequest();
    }

}
