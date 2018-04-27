package com.computeralchemist.consoleUI.components.computerCase;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 09-04-2018
 * */

@Getter
@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ComputerCaseParameters {
    private String type;
    private double height;
    private double width;
    private double weight;
    private List<String> compatibilityMotherboards;
    private List<String> connectors;

}
