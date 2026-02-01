package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {

        String browser = System.getProperty("browser", "chrome").toLowerCase();

        switch (browser) {
            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            case "chrome":
                driver.set(new ChromeDriver());
                break;
            default:
                System.out.println("No browser found");
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
