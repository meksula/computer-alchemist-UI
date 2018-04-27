package com.computeralchemist.consoleUI.components.disk;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 07-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Disk extends ComputerComponent {

    private long productId;

    private DiskParameters diskParameters;

}
