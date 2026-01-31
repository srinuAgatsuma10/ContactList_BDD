package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import PageObjects.LoginPage;
import utils.ConfigReader;

public class LoginSteps {

    LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        // Handled in BaseTest setup
        loginPage = new LoginPage();
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() throws InterruptedException {
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isContactListDisplayed(),
                "Login failed - Logout button not visible");
    }
}