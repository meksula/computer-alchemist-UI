package com.computeralchemist.consoleUI.gui.ui;

import com.computeralchemist.consoleUI.api.DataProvider;
import com.computeralchemist.consoleUI.exception.CannotReadTypeException;
import com.computeralchemist.consoleUI.gui.dataPresentation.PresenterFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author
 * Karol Meksuła
 * 27-04-2018
 * */

public abstract class UIManager {
    protected PresenterFactory presenterFactory;
    DataProvider dataProvider;

    public abstract void arrangePane(Pane pane) throws IOException;

    String getType(String source) {
        Pattern pattern = Pattern.compile("=[a-z]{3,},");
        Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            String result = matcher.group();
            return result.substring(1, result.length() - 1);
        }

        throw new CannotReadTypeException(source);
    }

}
