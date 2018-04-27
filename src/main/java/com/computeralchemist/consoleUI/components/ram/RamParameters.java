package com.computeralchemist.consoleUI.components.ram;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
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
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RamParameters {
    private String memoryType;
    private String cooler;
    private int modules;
    private int capacityGb;
    private double frequency;
    private String socketType;
}
