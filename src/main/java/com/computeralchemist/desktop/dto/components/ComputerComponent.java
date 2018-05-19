package com.computeralchemist.desktop.dto.components;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 25-04-2018
 * */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ComputerComponent {
    private String componentType;
    private String producent;
    private String model;
    private String description;
    private String urlToResource;
    private double compatibleIndex;
    private long allPoints;
    private long votes;
    private double ratesEvg;

    public abstract long getProductId();
}
