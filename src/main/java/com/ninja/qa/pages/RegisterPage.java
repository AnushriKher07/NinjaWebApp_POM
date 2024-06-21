package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;
	@FindBy(id="input-firstname")
	private WebElement firstNameField;

	@FindBy(id="input-lastname")
		private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(id="input-confirm")
	private WebElement confirmpasswordfield;
	
	@FindBy(name="agree")
	private WebElement agreecheckbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continuebutton;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	public void enterEmail (String emailFieldText) {
		emailField.sendKeys(emailFieldText);
	}
	public void enterTelephone (String TelephoneFieldText) {
		telephoneField.sendKeys(TelephoneFieldText);
	}
	
	public void enterPassword (String PasswordFieldText) {
		passwordfield.sendKeys(PasswordFieldText);
	}
	public void enterConfirmPassword (String ConfirmPasswordFieldText) {
		confirmpasswordfield.sendKeys(ConfirmPasswordFieldText);
	}
	public void selectcheckbox() {
		agreecheckbox.click();
		
	}
	public void clickonContinuebutton() {
		continuebutton.click();
		
	}
}


