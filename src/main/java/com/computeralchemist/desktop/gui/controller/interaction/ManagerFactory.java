package com.computeralchemist.desktop.gui.controller.interaction;

import com.computeralchemist.desktop.gui.controller.interaction.manager.PaneManager;

/**
 * @Author
 * Karol Meksuła
 * 15-05-2018
 * */

public interface ManagerFactory {
    PaneManager createManager(String type);
}
