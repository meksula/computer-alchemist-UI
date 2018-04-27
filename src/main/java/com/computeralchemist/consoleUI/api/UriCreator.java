package com.computeralchemist.consoleUI.api;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 26-04-2018
 * */

public interface UriCreator {
    String prepareUri(List<String> pathElements);
}
