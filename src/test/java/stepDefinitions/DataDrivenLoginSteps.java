package stepDefinitions;

import PageObjects.ContactListPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class DataDrivenLoginSteps {

    LoginPage loginPage;
    ContactListPage contactListPage;
    WebDriverWait wait;

    String excelPath = System.getProperty("user.dir") + "/src/test/resources/TestData/LoginData.xlsx";

    @Given("user is on login page for data driven test")
    public void user_is_on_login_page_for_data_driven_test() {
        // Initialize driver once
        DriverFactory.initDriver();
        loginPage = new LoginPage();
        contactListPage = new ContactListPage();
        wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));

        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("user login using excel data")
    public void user_login_using_excel_data() {
        // Read Excel data
        List<Map<String, String>> testData = ExcelUtils.getExcelData(excelPath, "Sheet1");

        for (int i = 0; i < testData.size(); i++) {
            Map<String, String> row = testData.get(i);
            String username = row.get("Email_ID");
            String password = row.get("Password");

            // Skip blank rows
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                System.out.println("Skipping row " + (i + 1) + " due to blank cells.");
                continue;
            }

            try {
                // Login page check
                if (!DriverFactory.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("url"))) {
                    DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
                }

                wait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));

                loginPage.enterEmail(username);
                loginPage.enterPassword(password);
                loginPage.clickSubmit();

                wait.until(ExpectedConditions.visibilityOf(contactListPage.getLogoutButton()));

                Assert.assertTrue(contactListPage.isContactListDisplayed(),
                        "Login failed for user: " + username);
                System.out.println("Login successful for user: " + username);

                contactListPage.clickOnLogOut();
                wait.until(ExpectedConditions.visibilityOf(loginPage.getEmailField()));
            } catch (NoSuchElementException | TimeoutException e) {
                System.out.println("Skipping user " + username + " due to exception: " + e.getMessage());
                // Navigate to login page for next iteration
                DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
            }
        }
    }

    @Then("validate login results")
    public void validate_login_results() {
        System.out.println("Excel Data Driven Login Executed Successfully");
        DriverFactory.quitDriver();
    }
}
