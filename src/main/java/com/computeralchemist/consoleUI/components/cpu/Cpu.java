package com.computeralchemist.consoleUI.components.cpu;

import com.computeralchemist.consoleUI.components.ComputerComponent;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 03-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cpu extends ComputerComponent {

    private long productId;

    private CpuParameters cpuParameters;

}
