package com.computeralchemist.desktop.gui.controller.presentation;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.cpu.Cpu;
import com.computeralchemist.desktop.dto.components.motherboard.Motherboard;
import com.computeralchemist.desktop.gui.controller.presentation.nodes.LabelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class ComponentListPresenter extends ResultPresenter implements Initializable {

    /*
    * TODO init this, after logic impl
    * Listę jakie komponenty załadować masz w zmiennej "super.fxmlName"
    * */

    private static List<ComputerComponent> componentList = new ArrayList<>(Arrays.asList(new Cpu(), new Motherboard()));

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
                //TODO
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
