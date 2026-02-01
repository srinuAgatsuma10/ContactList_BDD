package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinitions","Hooks"},
        dryRun = false,
//        threads = 1,
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@Smoke"
)
@Test(singleThreaded = true)
public class Runner extends AbstractTestNGCucumberTests {
        @BeforeClass(alwaysRun = true)
        @Parameters("browser")
        public void setBrowser(@Optional("chrome") String browser) {
                System.setProperty("browser", browser);
        }
}