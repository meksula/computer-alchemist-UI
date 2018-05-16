package com.computeralchemist.desktop.gui.controller.interaction.manager;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public class HelpButtonManager extends PaneManager implements Initializable {

    @Override
    protected String fxmlName() {
        return "help";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /*
        * Tutaj zrobimy tak, że na czystym, głównym anchor pane napiszemy w labelce wczytany tekst z pliku,
        * w którym opisane będzie co można zrobić itd.
        *
        * */
    }
}
