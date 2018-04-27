package com.computeralchemist.consoleUI.gui.dataPresentation;

import com.computeralchemist.consoleUI.components.ComputerComponent;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public class PresenterFactory {

    public DataPresenter createGuiPresenter(ComputerComponent component) {
        if (component.getComponentType().equals("cpu"))
            return new CpuDataPresenter(component);
        else if (component.getComponentType().equals("motherboard"))
            return new MotherboardDataPresenter(component);
        else if (component.getComponentType().equals("ram"))
            return new RamDataPresenter(component);
        else if (component.getComponentType().equals("disk"))
            return new DiskDataPresenter(component);
        else if (component.getComponentType().equals("supply"))
            return new SupplyDataPresenter(component);
        else if (component.getComponentType().equals("gpu"))
            return new GpuDataPresenter(component);
        else if (component.getComponentType().equals("computercase"))
            return new CaseDataPresenter(component);

        return null;
    }

}
