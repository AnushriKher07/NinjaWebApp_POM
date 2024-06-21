package com.ninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninja.qa.utils.Utilities;

public class datadrivenLogin {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver (e.g., ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\anush\\\\eclipse-workspace\\\\TutorialsNinja\\\\Driver\\\\chromedriver.exe");
        driver = new ChromeDriver();
        // Other setup steps if needed
    }

    @Test(dataProvider = "getData")
    public void loginTest(String Email, String Password) {
        // Navigate to the login page
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

        // Perform login using the provided username and password
        driver.findElement(By.id("input-email")).sendKeys(Email);
        driver.findElement(By.id("input-password")).sendKeys(Password);
        driver.findElement(By.id("loginButton")).click();
        
        // Wait for a certain duration (e.g., 5 seconds) after login
        waitForSeconds(5);

        // Add assertions or validation as needed
        // Example: Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    // Utility method to wait for a specified number of seconds
    private void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Add assertions or validation as needed
        // Example: Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        Utilities.openExcelFile("C:\\Users\\anush\\eclipse-workspace\\NinjaWebApp\\src\\main\\java\\com\\ninja\\qa\\testdata\\NinjaWebAppTestData.xlsx");
        Object[][] data = Utilities.getTestData("Login");
        Utilities.closeExcelFile();
        return data;
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}



