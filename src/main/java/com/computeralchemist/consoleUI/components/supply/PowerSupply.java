package com.computeralchemist.consoleUI.components.supply;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 07-08-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class PowerSupply extends ComputerComponent {

    private long productId;

    private PowerSupplyParameters powerSupplyParameters;

}
