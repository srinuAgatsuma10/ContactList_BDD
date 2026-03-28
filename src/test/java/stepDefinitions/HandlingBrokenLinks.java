package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class HandlingBrokenLinks {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();
        //Accessing total links in webpage
        List<WebElement> links = driver.findElements(By.tagName("a"));

        //Count no of broken Links
        int brokenLinks = 0;

        for (WebElement linkElement : links) {
            String hrefValue = linkElement.getAttribute("href");
            if (hrefValue == null || hrefValue.isEmpty()) {
                System.out.println("href attribute is empty, not possible to check");
                continue;
            }
            //Hit URL to the server
            try {
                URL linkUrl = new URL(hrefValue); //convert href value from string to URL
                HttpURLConnection con = (HttpURLConnection) linkUrl.openConnection(); //open connection to the server
                con.connect(); //connect to the server and send request to the server

                if (con.getResponseCode() >= 400) {
                    System.out.println(hrefValue + "====> Broken Link");
                    brokenLinks++;
                } else {
                    System.out.println(hrefValue + "====> Not a broken link");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
