package PageObjects;

import BasePageTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp_Page extends BasePage {
    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;

    public void enterFirstName(String fname){
        firstNameField.sendKeys(fname);
    }

    public void enterLastName(String lname){
        lastNameField.sendKeys(lname);
    }

    public void enterEmail(String email){
        emailField.sendKeys(email);
    }

    public void enterPassword(String pass){
        passwordField.sendKeys(pass);
    }

    public void clickOnSubmit(){
        submitButton.click();
    }
}
