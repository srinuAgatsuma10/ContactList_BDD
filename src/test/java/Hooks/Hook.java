package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.DriverFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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