package com.computeralchemist.desktop.gui.controller.presentation;

import com.computeralchemist.desktop.dto.set.ComputerSet;
import com.computeralchemist.desktop.gui.controller.presentation.nodes.LabelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author
 * Karol Meksuła
 * 16-05-2018
 * */

public class SetListPresenter extends ResultPresenter implements Initializable {
    private final String REQUIRED_FXML = "/templates/parts/sets/setListPresent.fxml";
    private static List<ComputerSet> computerSetList = new ArrayList<>(); //Tutaj inicjalizacja z REST API

    @FXML
    private VBox vbox;

    @Override
    protected String setFxmlPath() {
        return REQUIRED_FXML;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LabelFactory labelFactory = new LabelFactory() {
            @Override
            protected void presentIndicatedComponent(String model) {
                /*TODO akcja po kliknięciu w Label*/
            }
        };

        AtomicInteger counter = new AtomicInteger(1);
        computerSetList.forEach(item -> {
            Label label = labelFactory.createLabel(counter + ". " + item.getAuthor() + ", " + item.getCreateDate() + ", VOTES: " +
                    item.getVotes());
            counter.getAndIncrement();
            vbox.getChildren().add(label);
        });
    }

}
