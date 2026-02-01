package stepDefinitions;

import PageObjects.ContactListPage;
import PageObjects.LoginPage;
import PageObjects.SignUp_Page;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class SignUpSteps {
    LoginPage loginPage;
    SignUp_Page signUpPage;
    ContactListPage contactListPage;

    public SignUpSteps(){
        loginPage = new LoginPage();
        signUpPage = new SignUp_Page();
        contactListPage = new ContactListPage();
    }

    @Given("click on signUp button in login page")
    public void click_on_sign_up_button_in_login_page() {
        loginPage.clickSingnUpButton();
    }

    @When("Enter all user details")
    public void enter_all_user_details() {
        RandomData_Generator random = new RandomData_Generator();
        signUpPage.enterFirstName(random.firstNameGenerator());
        signUpPage.enterLastName(random.lasttNameGenerator());
        signUpPage.enterEmail(random.emailGenerator());
        signUpPage.enterPassword(random.passwordGenerator());
        signUpPage.clickOnSubmit();
    }

    @Then("user shold create account succesfully")
    public void user_shold_create_account_succesfully() {
        Assert.assertTrue(contactListPage.isContactListDisplayed(),
                "Login failed - ContactList Logo is not visible");
    }
}
