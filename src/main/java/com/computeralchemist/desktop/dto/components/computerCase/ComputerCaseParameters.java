package com.computeralchemist.desktop.dto.components.computerCase;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputerCaseParameters {
    private String type;
    private double height;
    private double width;
    private double weight;
    private List<String> compatibilityMotherboards;
    private List<String> connectors;

}
