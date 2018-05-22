package com.computeralchemist.desktop.logic.jersey;

import com.computeralchemist.desktop.dto.components.ComputerComponent;
import com.computeralchemist.desktop.dto.components.supply.PowerSupply;
import com.computeralchemist.desktop.dto.components.supply.PowerSupplyParameters;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 22-05-2018
 * */

public class PostApiConnectorTest {
    private static PostApiConnector postApiConnector;

    @BeforeClass
    public static void setUp() {
        DefaultAuthentication.getInstance().login("karoladmin", "karoladmin");
        postApiConnector = new PostApiConnector();
    }

    @Test
    public void postComponent() {
        String httpStatus = postApiConnector.postComponent(getUri(), getComponent());
        assertEquals("201", httpStatus);
    }

    private String getUri() {
        return "http://localhost:8080/components/";
    }

    private ComputerComponent getComponent() {
        PowerSupply powerSupply = new PowerSupply();
        PowerSupplyParameters parameters = new PowerSupplyParameters();
        powerSupply.setPowerSupplyParameters(parameters);

        powerSupply.setComponentType("supply");
        powerSupply.setProducent("Corsair");
        powerSupply.setModel("VS 550W (CP-9020097-EU)");
        powerSupply.setDescription("Stabilny, cichy i solidnie wykonany zasilacz, setki pozytywnych komentarzy użytkowników!");

        parameters.setStandard("ATX");
        parameters.setPower(550);
        parameters.setPfc("Aktywny");
        parameters.setConnectors(Arrays.asList("ATX 24-pin (20+4)", "PCI-E 8-pin (6+2)", "SATA", "Molex"));
        parameters.setModularCable(false);
        parameters.setCooler("Fan");

        return powerSupply;
    }

}