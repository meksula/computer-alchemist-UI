package com.computeralchemist.desktop.gui.controller.presentation;

import com.computeralchemist.desktop.dto.set.ComputerSet;
import com.computeralchemist.desktop.gui.controller.presentation.nodes.LabelFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
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
                ComputerSet computerSet = setList.stream()
                        .filter(set -> set.getSetId() == Long.parseLong(model))
                        .findFirst()
                        .get();

                presenter.getChildren().clear();
                new SetGetPresenter().presentResult(presenter, computerSet);
            }
        };

        AtomicInteger counter = new AtomicInteger(1);
        setList.forEach(item -> {
            Label label = labelFactory.createLabel(counter + ". " + item.getCreateDate() + " author: " + item.getAuthor() +
                    ", " + item.getSetId() + ", VOTES: " + item.getVotes());
            counter.getAndIncrement();
            vbox.getChildren().add(label);
        });
    }

    @Override
    public void presentResult(Parent parent, List<?> list) {
        ResultPresenter.presenter = (Pane) parent;
        ResultPresenter.setList = (List<ComputerSet>) list;

        fxmlPath = setFxmlPath();
        loadPresenter();
    }

}
