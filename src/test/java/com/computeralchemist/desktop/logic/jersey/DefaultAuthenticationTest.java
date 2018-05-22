package com.computeralchemist.desktop.logic.jersey;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 17-05-2018
 *
 *
 * NOTICE THAT:
 * Some of these test pass only when API is running.
 * */

public class DefaultAuthenticationTest {
    private AuthenticationApi  authenticationApi;

    private final String INVALID_USERNAME = "Holahola244.s";
    private final String INVALID_PASSWORD = "passwordNotKnown";
    private final String EXPECTED_UNAUTHORIZED = "Unauthorized";

    private final String VALID_USERNAME = "karoladmin";
    private final String VALID_PASSWORD = "karoladmin";
    private final String EXPECTED_AUTHENTICATED = "OK";

    @Before
    public void setUp() {
        authenticationApi = new DefaultAuthentication();
    }

    @Test
    public void authenticationShouldNotPassTest() {
        int result = authenticationApi.login(INVALID_USERNAME, INVALID_PASSWORD);
        assertEquals(EXPECTED_UNAUTHORIZED, result);
    }

    @Test
    public void authenticationShouldPassTest() {
        int result = authenticationApi.login(VALID_USERNAME, VALID_PASSWORD);
        assertEquals(EXPECTED_AUTHENTICATED, result);
    }

    @Test
    public void tryLoginWithoutCredencials() {
        int result = authenticationApi.login("", "");
        assertEquals(EXPECTED_UNAUTHORIZED, result);
    }

}