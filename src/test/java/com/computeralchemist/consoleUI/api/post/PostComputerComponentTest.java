package com.computeralchemist.consoleUI.api.post;

import com.computeralchemist.consoleUI.components.cpu.Cpu;
import com.computeralchemist.consoleUI.exception.EmptyUriException;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.MultivaluedMap;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @Author
 * Karol Meksuła
 * 30-04-2018
 * */

public class PostComputerComponentTest {
    private PostComputerComponent postComputerComponent;
    private Cpu cpu = new Cpu();
    private final String URI = "http://localhost:8080/components";
    private final String JSON = "{\"producent\":\"Intel\", \"model\":\"noname\"}";

    @Before
    public void setUp() {
        postComputerComponent = new PostComputerComponent();
    }

    @Test
    public void setComponentAndUriTest() {
        postComputerComponent.setObject(cpu);
        postComputerComponent.setUri(URI);

        assertNotNull(postComputerComponent.getClient());
        assertNotNull(postComputerComponent.getUri());
        assertNotNull(postComputerComponent.getComputerComponent());
        assertNotNull(postComputerComponent.getClient());
    }

    @Test
    public void executePostRequestTest() {
        postComputerComponent.setObject(cpu);
        postComputerComponent.setUri(URI);

        postComputerComponent.executePostRequest();
    }

}