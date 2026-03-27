package stepDefinitions;

import PageObjects.ContactListPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginDataDrvier_StepsTwo {

    LoginPage loginPage;
    ContactListPage contactListPage;

    public LoginDataDrvier_StepsTwo() {
        loginPage = new LoginPage();
        contactListPage = new ContactListPage();
    }


    @Given("user navigates to login page")
    public void user_navigates_to_login_page() {
        // handled in hooks
    }

    @When("user logs in using username {string} and password {string}")
    public void user_logs_in(String username, String password) throws InterruptedException {

        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickSubmit();

        Thread.sleep(2000);
    }

    @Then("login outcome should be {string}")
    public void login_outcome_should_be(String expectedResult) {

        if (expectedResult.equalsIgnoreCase("success")) {
            Assert.assertTrue(contactListPage.isContactListDisplayed(),
                    "Expected login success but failed");
        } else {
            Assert.assertTrue(contactListPage.isContactListDisplayed(),
                    "Expected login failure but passed");
        }
    }
}