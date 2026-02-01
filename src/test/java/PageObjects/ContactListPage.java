package PageObjects;

import BasePageTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement contactListLogo;

    @FindBy(xpath = "//button[@id='logout']")
    WebElement logoutButton;

    public boolean isContactListDisplayed() {
        return contactListLogo.isDisplayed();
    }

    public void clickOnLogOut(){
        logoutButton.click();
    }

    /* For Data Driven Test*/
    public WebElement getLogoutButton() { return logoutButton; }
}
