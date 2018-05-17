package com.computeralchemist.desktop.dto.components.supply;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
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
