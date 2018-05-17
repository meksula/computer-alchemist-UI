package com.computeralchemist.desktop.logic.uri;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 *
 * Tip:
 * If you use that interface notice that uriParts is list with parts of building URI address.
 * Place values in correctly order!
 * */

public interface UriBuilder {
    String buildUri(List<String> uriParts);
}
