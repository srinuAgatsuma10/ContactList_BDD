package PageObjects;

import BasePageTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']" )
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//button[@id='signup']")
    WebElement signUpBUtton;


    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPassword(String pass){
        passwordField.sendKeys(pass);
    }

    public void clickSubmit(){
        loginButton.click();
    }

    public void clickSingnUpButton() {
        signUpBUtton.click();
    }
}
