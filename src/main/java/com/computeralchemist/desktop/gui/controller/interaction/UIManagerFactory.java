package com.computeralchemist.desktop.gui.controller.interaction;

import com.computeralchemist.desktop.gui.controller.interaction.manager.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author
 * Karol Meksuła
 * 14-05-2018
 * */

public class UIManagerFactory implements ManagerFactory {
    private Map<String, PaneManager> factoryPlain;

    public UIManagerFactory() {
        initializeFactoryPlain();
    }

    private void initializeFactoryPlain() {
        factoryPlain = new LinkedHashMap<>();
        factoryPlain.put("getComponentButton", new ComponentGetButtonManager());
        factoryPlain.put("getSetButton", new SetGetButtonManager());
        factoryPlain.put("getComponentListButton", new ComponentListButtonManager());
        factoryPlain.put("getSetListButton", new SetListButtonManager());
        factoryPlain.put("postComponent", new ComponentPostButtonManager());
        factoryPlain.put("postSet", new SetPostButtonManager());
        factoryPlain.put("pickpocketComponent", new PickpocketComponentButtonManager());
        factoryPlain.put("pickpocketProperties", new PickpocketPropertiesButtonManager());
        factoryPlain.put("account", new AcountButtonManager());
        factoryPlain.put("help", new HelpButtonManager());
    }

    @Override
    public PaneManager createManager(String type) {
        return factoryPlain.get(type);
    }
}
