package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;
import utils.DriverFactory;

public class Hook {

    @Before
    public void setUp() {
        System.out.println(">>> Hooks Before executed");
        DriverFactory.initDriver();
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}