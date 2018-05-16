package com.computeralchemist.desktop.dto.set;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author
 * Karol Meksuła
 * 11-04-2018
 * */

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class GamingComputerSet extends ComputerSet {

    private long setId;

}
