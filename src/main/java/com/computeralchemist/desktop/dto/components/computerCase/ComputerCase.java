package com.computeralchemist.desktop.dto.components.computerCase;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ComputerCase extends ComputerComponent {

    private long productId;

    private ComputerCaseParameters computerCaseParameters;

}
