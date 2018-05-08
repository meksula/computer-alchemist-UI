package com.computeralchemist.consoleUI.api.post;

import javax.ws.rs.core.MultivaluedMap;

/**
 * @Author
 * Karol Meksuła
 * 30-04-2018
 * */

public interface PostObject {
    void setUri(String uri);

    void setObject(Object object);

    MultivaluedMap<String, String> executePostRequest();
}
