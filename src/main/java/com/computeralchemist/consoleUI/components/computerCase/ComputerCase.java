package com.computeralchemist.consoleUI.components.computerCase;

import com.computeralchemist.consoleUI.components.ComputerComponent;
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
