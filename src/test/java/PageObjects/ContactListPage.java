package PageObjects;

import BasePageTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactListPage extends BasePage {

    @FindBy(xpath = "//h1")
    WebElement contactListLogo;

    public boolean isContactListDisplayed() {
        return contactListLogo.isDisplayed();
    }
}
