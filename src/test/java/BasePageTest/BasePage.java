package BasePageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class BasePage {


    protected WebDriver driver;
    public BasePage() {
        this.driver = DriverFactory.getDriver();
        PageFactory.initElements(driver, this);
    }


    //    protected WebDriver driver(){
//        return DriverFactory.getDriver();
//    };
//    protected WebDriver driver() {
//        WebDriver driver = DriverFactory.getDriver();
//        System.out.println("Driver in BasePage: " + driver);
//        return driver;
//    }


//    public BasePage() {
//        this.driver = DriverFactory.getDriver();
//    }

//    protected void click(By locator) {
//        driver().findElement(locator).click();
//    }
//
//    protected void type(By locator, String text) {
//        WebElement element = driver().findElement(locator);
//        element.clear();
//        element.sendKeys(text);
//    }
//
//    protected String getText(By locator) {
//        return driver().findElement(locator).getText();
//    }
}
