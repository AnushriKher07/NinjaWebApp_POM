package com.ninja.qa.testcases;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ninja.qa.base.Base;
import com.ninja.qa.pages.Homepage;
import com.ninja.qa.pages.RegisterPage;
import com.ninja.qa.utils.Utilities;

import junit.framework.Assert;

public class Registeration extends Base{
	RegisterPage registerPage;
    public Registeration() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	driver= initializeBrowserAndOpenApplicationURL("firefox");
    	Homepage homepage = new Homepage(driver);
		homepage.clickonMyAccount();
		 registerPage = homepage.selectRegisterOption();
        //driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
	    //driver.findElement(By.linkText("Register")).click();

    }
	@Test(priority=1)
	public void verifyRegisterWIthValidData(){
		//RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstname"));
	    //driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
	    //driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
        registerPage.enterLastName(dataprop.getProperty("lastname"));
	    String email = Utilities.generateEmailWithTimestamp("user_", "_test");
	    //driver.findElement(By.id("input-email")).sendKeys(email);
	    registerPage.enterEmail(email);
	    //driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephonenumber"));
	    registerPage.enterTelephone(dataprop.getProperty("telephonenumber"));
        //driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	    registerPage.enterPassword(prop.getProperty("validPassword"));
	    //driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
	    registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
	    //driver.findElement(By.name("agree")).click();
	    registerPage.selectcheckbox();
	    //driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	    registerPage.clickonContinuebutton();	    
	    	
	    	String expectedHeading= "Your Account Has Been created ";
	    	WebElement headingElement = driver.findElement(By.xpath(" //div[@id='content']/h1"));
	    	String actualHeading = headingElement.getText();
	    	
	    	if (actualHeading.equals(expectedHeading)) {
	    		System.out.println("Proper page heading displayed");
	    	}
	    	else {
	    		System.out.println("Proper page heading not displayed. Failed ");

	    	}
	    	}

		@Test(priority=2)
		public void VerifyRegisterWithExixtingEmail() {
			//RegisterPage registerPage = new RegisterPage(driver);
			
			registerPage.enterFirstName(dataprop.getProperty("firstname"));
			//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
	        
			registerPage.enterLastName(dataprop.getProperty("lastname"));
	        //driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		    
			registerPage.enterEmail(dataprop.getProperty("duplicateemail"));
             //driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("duplicateemail"));
			
		    registerPage.enterTelephone(dataprop.getProperty("telephonenumber"));
		    //driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephonenumber"));
		    
		    registerPage.enterPassword(prop.getProperty("validPassword"));
		    //driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		    
		    registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
		    //driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		   
		    registerPage.selectcheckbox();
		    //driver.findElement(By.name("agree")).click();
		    
		    registerPage.clickonContinuebutton();
		    //driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		    
	        		   
		    String expectedHeading= "Warning: Email Address is already registered";
	    	WebElement headingElement = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]"));
	    	String actualHeading = headingElement.getText();
	    	
	    	if (actualHeading.equals(expectedHeading)) {
	    		System.out.println("Proper page heading displayed");
	    	}
	    	else {
	    		System.out.println("Proper page heading not displayed. Failed ");

	    	}
	    	}
   
		
	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

		    
		    
			
			
		
}
