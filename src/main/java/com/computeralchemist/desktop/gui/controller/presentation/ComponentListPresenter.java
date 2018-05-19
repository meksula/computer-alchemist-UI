package com.computeralchemist.desktop.gui.controller.presentation;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.gui.controller.interaction.manager.ComponentGetButtonManager;
import com.computeralchemist.desktop.gui.controller.presentation.nodes.LabelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class ComponentListPresenter extends ResultPresenter implements Initializable {

    @FXML
    private VBox vbox;

    @Override
    protected String setFxmlPath() {
        return "/templates/parts/componentList.fxml";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LabelFactory labelFactory = new LabelFactory() {
            @Override
            protected void presentIndicatedComponent(String model) {
                ComputerComponent computerComponent = componentList.stream().filter(component -> component.getModel().equals(model))
                        .findFirst()
                        .get();

                presenter.getChildren().clear();
                new ComponentGetPresenter().presentResult(presenter, computerComponent);
            }
        };

        AtomicInteger counter = new AtomicInteger(1);
        componentList.forEach(item -> {
            Label label = labelFactory.createLabel(counter + ". " + item.getProducent() + ", " + item.getModel() + ", VOTES: " +
                                        item.getVotes());
            counter.getAndIncrement();
            vbox.getChildren().add(label);
        });

    }

}
