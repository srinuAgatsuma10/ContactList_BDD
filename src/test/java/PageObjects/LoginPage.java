package PageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@id='submit']");
    private By contactList = By.xpath("//h1[normalize-space()='Contact List']");

    public void login(String email, String password) throws InterruptedException {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
        Thread.sleep(3000);
    }

    public boolean isContactListDisplayed() {
        return driver().findElement(contactList).isDisplayed();
    }
}
