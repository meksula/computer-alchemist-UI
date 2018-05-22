package com.computeralchemist.desktop.logic.jersey;

import com.computeralchemist.desktop.dto.components.ComputerComponent;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public interface PostApi {
    String postComponent(String uri, ComputerComponent computerComponent);
}
