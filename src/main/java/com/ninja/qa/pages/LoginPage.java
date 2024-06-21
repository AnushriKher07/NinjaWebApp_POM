package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;

@FindBy(id="input-email")
private WebElement emailAddressField;

@FindBy(id="input-password")
private WebElement passwordField;

@FindBy(xpath="//input[@value='Login']")
private WebElement loginbutton;

@FindBy(xpath="//div[contains(@class,'alert-dismissable')]")
private WebElement emailPasswordNotMatching;

public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);

}

//Actions

public void enterEmailAddress(String emailText) {
emailAddressField.sendKeys(emailText);
}

public void enterPassword(String passwordText) {
	passwordField.sendKeys(passwordText);
}

public AccountPage clickonLoginbutton() {
	loginbutton.click();
	return new AccountPage(driver);
}
public String retrieveEmailPasswordNotMatching() {
	String WarningText= emailPasswordNotMatching.getText();
	return WarningText;
}
}