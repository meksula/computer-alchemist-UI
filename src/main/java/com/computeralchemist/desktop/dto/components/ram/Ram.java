package com.computeralchemist.desktop.dto.components.ram;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 05-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Ram extends ComputerComponent {

    private long productId;

    private RamParameters ramParameters;

}
