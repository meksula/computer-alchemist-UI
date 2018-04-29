package com.computeralchemist.consoleUI.components.disk;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@EqualsAndHashCode
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DiskParameters {
    private DriveType type;
    private String format;
    private int capacity;
    private double readSpeed;
    private double writeSpeed;
}
