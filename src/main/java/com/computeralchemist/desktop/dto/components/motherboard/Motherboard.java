package com.computeralchemist.desktop.dto.components.motherboard;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Motherboard extends ComputerComponent {

    private long productId;

    private MotherboardParameters motherboardParameters;

}
