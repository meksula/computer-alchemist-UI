package com.computeralchemist.desktop.dto.components.motherboard;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 30-03-2018
 * */

@Getter
@Setter
@EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MotherboardParameters {
    private String type;
    private String chipset;
    private String socket;
    private int ramSockets;
    private String bios;
    private String memoryType;
    private double memoryFrequency;
    private List<String> procesorAvailables;
    private List<String> otherSockets;
}
