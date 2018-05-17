package com.computeralchemist.desktop.dto.components.disk;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
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
