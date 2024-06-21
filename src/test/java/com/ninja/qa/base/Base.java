package com.ninja.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	protected WebDriver driver;
	public Properties dataprop;
	
    protected Properties prop; // Declare prop at the class level

    public Base() throws IOException {
        prop = new Properties();
        FileInputStream input = new FileInputStream("src/main/java/com/NinjaWeb/qa/config/config.properties");
        prop.load(input);

        dataprop = new Properties(); 
        FileInputStream input1 = new FileInputStream("C:\\Users\\anush\\eclipse-workspace\\NinjaWebApp_POM\\src\\main\\java\\com\\ninja\\qa\\testdata\\testdata.properties");
        dataprop.load(input1);
        // Add this line
        

	}

	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName)  {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Automation\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
		
		
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.get("https://tutorialsninja.com/demo/");

        return driver;

}
}
