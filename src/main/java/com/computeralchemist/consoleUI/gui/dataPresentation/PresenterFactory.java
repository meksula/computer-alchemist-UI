package com.computeralchemist.consoleUI.gui.dataPresentation;

import com.computeralchemist.desktop.dto.components.ComputerComponent;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public class PresenterFactory {
    private DataPresenter dataPresenter;
    private String resource;

    public DataPresenter createGuiPresenter(ComputerComponent component) {
        dataPresenter = new DataPresenter();

        if (component.getComponentType().equals("cpu"))
            this.resource = "/templates/parts/components/cpu.fxml";
        else if (component.getComponentType().equals("motherboard"))
            this.resource = "/templates/parts/components/motherboard.fxml";
        else if (component.getComponentType().equals("ram"))
            this.resource = "/templates/parts/components/ram.fxml";
        else if (component.getComponentType().equals("disk"))
            this.resource = "/templates/parts/components/disk.fxml";
        else if (component.getComponentType().equals("supply"))
            this.resource = "/templates/parts/components/supply.fxml";
        else if (component.getComponentType().equals("gpu"))
            this.resource = "/templates/parts/components/gpu.fxml";
        else if (component.getComponentType().equals("computercase"))
            this.resource = "/templates/parts/components/computercase.fxml";

        dataPresenter.setResourceUri(resource);
        dataPresenter.setComputerComponent(component);
        return dataPresenter;
    }

}
