package com.ninja.qa.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ninja.qa.base.Base;
import com.ninja.qa.pages.AccountPage;
import com.ninja.qa.pages.Homepage;
import com.ninja.qa.pages.LoginPage;
import com.ninja.qa.utils.Utilities;

import junit.framework.Assert;
import sun.util.calendar.BaseCalendar.Date;

public class Logintest extends Base {
	LoginPage loginPage;
		public Logintest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


		// TODO Auto-generated constructor stub
	



    @BeforeMethod
    public void setUp() {
    	driver= initializeBrowserAndOpenApplicationURL("chrome");
    	//driver= initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName");
    	Homepage homepage = new Homepage(driver);
    			homepage.clickonMyAccount();
    			 loginPage = homepage.selectLoginOption();
        //driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        //driver.findElement(By.linkText("Login")).click();
    			//homepage.selectLoginOption();
    }

    @Test(priority=1)
    public void verifyLoginWithValidCredentials()  {
    	
LoginPage loginPage = new LoginPage(driver);
loginPage.enterEmailAddress(prop.getProperty("validEmail"));
loginPage.enterPassword(prop.getProperty("validPassword"));
AccountPage accountPage = loginPage.clickonLoginbutton();
        //driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        //driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        //driver.findElement(By.xpath("//input[@value='Login']")).click();

//AccountPage accountPage = new AccountPage(driver);
//Assert.assertTrue(accountPage.getDisplayStatusOfEditYourACcountInformationOption());

        
//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

String expectedHeading= "Edit your account information";
WebElement headingElement = driver.findElement(By.linkText("Edit your account information"));
String actualHeading = headingElement.getText();

if (actualHeading.equals(expectedHeading)) {
	System.out.println("Proper page heading displayed");
}
else {
	System.out.println("Proper page heading not displayed. Failed ");

}
}

    @Test(priority=2)
    public void verifyLoginWithValidCredentialsTimestamp() {
    	
//LoginPage loginPage = new LoginPage(driver);
loginPage.enterEmailAddress(Utilities.generateTimestamp());
loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
loginPage.clickonLoginbutton();


        //driver.findElement(By.id("input-email")).sendKeys("usertest00"+generateEmailwithTimestamp()+"@gmail.com");
        //driver.findElement(By.id("input-password")).sendKeys("Pass@1234");
        //driver.findElement(By.xpath("//input[@value='Login']")).click();


//String actualWarningMessage =loginPage.retrieveEmailPasswordNotMatching();
//String expectedWarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
//Assert.assertTrue("Expected warning message is not displayed", actualWarningMessage.contains(expectedWarningMessage));

        //String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissable')]")).getText();
        //String expectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
        //Assert.assertTrue("Expected warning message is not displayed", actualWarningMessage.contains(expectedWarningMessage));
    }
    
    

    @Test(priority=3)
    public void verifyLoginWithInvalidPassword() {
    	//LoginPage loginPage = new LoginPage(driver);
    	loginPage.enterEmailAddress(prop.getProperty("validEmail"));
    	loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
    	loginPage.clickonLoginbutton();
    	  
        //driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        //driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
        //driver.findElement(By.xpath("//input[@value='Login']")).click();
    	
    	//String actualWarningMessage =loginPage.retrieveEmailPasswordNotMatching();
    	//String expectedWarningMessage=dataprop.getProperty("emailPasswordNoMatchWarning");
    	//Assert.assertTrue("Expected warning message is not displayed", actualWarningMessage.contains(expectedWarningMessage));

       // String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissable')]")).getText();
        //String expectedWarningMessage = dataprop.getProperty("emailPasswordNoMatchWarning");
        //Assert.assertTrue("Expected warning message is not displayed", actualWarningMessage.contains(expectedWarningMessage));
    	
    	String expectedHeading= "emailPasswordNoMatchWarning";
    	WebElement headingElement = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissable')]"));
    	String actualHeading = headingElement.getText();

    	if (actualHeading.equals(expectedHeading)) {
    		System.out.println("Proper page heading displayed");
    	}
    	else {
    		System.out.println("Proper page heading not displayed. Failed ");

    	}
    	}

    

    public String  generateEmailwithTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm_ss");

        return now.format(formatter);
    }
    
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
