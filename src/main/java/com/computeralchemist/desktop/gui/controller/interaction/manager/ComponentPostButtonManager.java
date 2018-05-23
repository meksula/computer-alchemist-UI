package com.computeralchemist.desktop.gui.controller.interaction.manager;

import com.computeralchemist.desktop.dto.creator.ComponentFactory;
import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.exception.FormNotCompleteException;
import com.computeralchemist.desktop.exception.InvalidInputException;
import com.computeralchemist.desktop.gui.alerts.FormNotCompletedAlert;
import com.computeralchemist.desktop.gui.alerts.NumberExpectedAlert;
import com.computeralchemist.desktop.gui.alerts.PostedComponentAlert;
import com.computeralchemist.desktop.logic.command.ComponentPostRequestCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class ComponentPostButtonManager extends PaneManager implements Initializable {
    private String requiredFxml = "post/postComponent";
    public static String componentType;
    private ComputerComponent computerComponent;
    private List<TextField> fields;

    @FXML
    private TextField value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11, value12, value13;

    @FXML
    private TextArea description;

    @FXML
    private CheckBox modular;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fields = Arrays.asList(value1, value2, value3, value4, value5, value6,
                value7, value8, value9, value10, value11, value12, value13);

        Tooltip tooltip = new Tooltip();
        tooltip.setText("If property is `list`\nplease divide values with ';'\nexample: value3;value65;value34");

        for(TextField tf : fields) {
            if (tf != null)
                tf.setTooltip(tooltip);
        }

    }

    @Override
    protected String fxmlName() {
        return requiredFxml;
    }

    @FXML
    public void setComponentType(ActionEvent actionEvent) {
        componentType = ((MenuItem) actionEvent.getSource()).getId();
        setConcreteComponent();
    }

    public void setConcreteComponent() {
        requiredFxml = "post/" + componentType;
        loadFXML();
    }

    @FXML
    public void executeRequest(ActionEvent actionEvent) {
        Map<String, String> properties = initProperties();

        if (modular != null)
            ComponentFactory.modular = modular.isSelected();

        try {
            computerComponent = ComponentFactory.valueOf(componentType).buildComponent(properties);
            ComponentFactory.modular = modular.isSelected();
        } catch (FormNotCompleteException | NullPointerException fnce) {
            new FormNotCompletedAlert().popupAlert(fnce.getMessage());
            return;
        } catch (InvalidInputException iie) {
            new NumberExpectedAlert().popupAlert(iie.getMessage());
            return;
        }

        String status = new ComponentPostRequestCommand(computerComponent).executePostRequest(Arrays.asList("components"));
        new PostedComponentAlert().popupAlert(status);
    }

    private Map<String, String> initProperties() {
        AtomicInteger counter = new AtomicInteger(1);
        final String VALUE = "value";

        Map<String, String> properties = new LinkedHashMap<>();
        properties.put("value0", description.getText());

        fields.forEach(textField -> {
            if (textField != null && textField.getText() != null) {
                properties.put(VALUE.concat(String.valueOf(counter.get())), textField.getText());
            }
            counter.incrementAndGet();
        });

        return properties;
    }

}