package BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class BasePage {

//    protected WebDriver driver(){
//        return DriverFactory.getDriver();
//    };
    protected WebDriver driver() {
        WebDriver driver = DriverFactory.getDriver();
        System.out.println("Driver in BasePage: " + driver);
        return driver;
    }



//    public BasePage() {
//        this.driver = DriverFactory.getDriver();
//    }

    protected void click(By locator) {
        driver().findElement(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = driver().findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return driver().findElement(locator).getText();
    }
}
