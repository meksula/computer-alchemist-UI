package com.computeralchemist.consoleUI.components.gpu;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class GraphicsCard extends ComputerComponent {

    private long productId;

    private GraphicsCardParameters graphicsCardParameters;

}
