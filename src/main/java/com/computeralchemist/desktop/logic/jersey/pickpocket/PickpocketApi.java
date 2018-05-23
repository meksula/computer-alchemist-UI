package com.computeralchemist.desktop.logic.jersey.pickpocket;

/**
 * @Author
 * Karol Meksuła
 * 23-05-2018
 * */

public interface PickpocketApi {
    String executeRequest(String uriToExecute, PickpocketLink linkToPost);
}
