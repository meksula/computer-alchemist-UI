package com.computeralchemist.consoleUI.components.gpu;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 08-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GraphicsCardParameters {
    private String chipset;
    private int memory;
    private String memoryType;
    private double memoryFrequency;
    private String mainConnectorType;
    private double length;
    private double clockFrequency;
    private String resolution;
    private String cooler;
    private List<String> standards;
    private List<String> connectors;

}
