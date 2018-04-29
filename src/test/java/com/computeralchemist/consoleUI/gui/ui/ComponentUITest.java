package com.computeralchemist.consoleUI.gui.ui;

import javafx.scene.layout.Pane;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 29-04-2018
 * */

public class ComponentUITest {
    private ComponentUI componentUI;
    private Pane pane = new Pane();

    @Before
    public void setUp() {
        componentUI = new ComponentUI();
    }


    @Test
    public void sizeShouldBeZero() {
        int count = pane.getChildren().size();
        assertEquals(0, count);
    }

    @Test
    public void arrangePaneTest() {
        /*pane.getChildren().size();
        componentUI.arrangePane(pane);*/
    }


}