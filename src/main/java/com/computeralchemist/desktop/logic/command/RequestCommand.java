package com.computeralchemist.desktop.logic.command;

import java.io.IOException;
import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 * */

public abstract class RequestCommand<T> {

    public T executeGetRequest(List<String> uriParts) throws IOException, ClassNotFoundException {
        String uri = createUri(uriParts);
        String jsonResult = executeGetUri(uri);

        return mapToObject(jsonResult);
    }

    public String executePostRequest(List<String> uriParts) {
        String uri = createUri(uriParts);
        return executePostUri(uri);
    }

    public T executePostPickpocketRequest(List<String> uriParts) throws IOException, ClassNotFoundException {
        String uri = createUri(uriParts);
        String jsonResult = executePostUri(uri);

        return mapToObject(jsonResult);
    }

    public T executePutRequest(List<String> uriParts) throws IOException, ClassNotFoundException {
        String uri = createUri(uriParts);
        String jsonResult = executePutUri(uri);

        return mapToObject(jsonResult);
    }

    public boolean executeDeleteRequest(List<String> uriParts) {
        String uri = createUri(uriParts);
        return executeDeleteUri(uri);
    }

    protected abstract T mapToObject(String jsonResult) throws IOException, ClassNotFoundException;

    protected abstract String createUri(List<String> uriParts);

    /*
    * Methods to optional override,
    * required if you want to use one of method above
    * */

    protected String executeGetUri(String uri) {
        return null;
    }

    protected String executePostUri(String uri) {
        return null;
    }

    protected String executePutUri(String uri) {
        return null;
    }

    protected boolean executeDeleteUri(String uri) {
        return false;
    }
}
