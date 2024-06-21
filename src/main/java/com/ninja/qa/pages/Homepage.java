package com.ninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
WebDriver driver;


//Objects
@FindBy(xpath="//span[text()='My Account']")
private WebElement myAccountDropmenu;

@FindBy(linkText="Login")
private WebElement loginoption;

@FindBy(xpath="//a[text()='Register']")
private WebElement registerOption;

public Homepage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//Actions

public void clickonMyAccount() {
	myAccountDropmenu.click();
}

public LoginPage selectLoginOption() {
	loginoption.click();
	return new LoginPage(driver);
}

public RegisterPage selectRegisterOption() {
	registerOption.click();
	return new RegisterPage(driver);
}





}
