package stepDefinitions;

import PageObjects.ContactListPage;
import io.cucumber.java.en.*;
import org.testng.Assert;
import PageObjects.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

    LoginPage loginPage;
    ContactListPage contactListPage;

    public LoginSteps() {
        loginPage = new LoginPage();
        contactListPage = new ContactListPage();
    }


    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        // Handled in BaseTest setup
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() throws InterruptedException {
        loginPage.enterEmail(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickSubmit();
        Thread.sleep(3000);
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(contactListPage.isContactListDisplayed(),
                "Login failed - ContactList Logo is not visible");
    }
}