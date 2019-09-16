package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	//Page Factory - OR;
	
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement loginbutton;
	
	@FindBy(xpath="//font[@color='red']")
	@CacheLookup
	WebElement signupbutton;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	@CacheLookup
	WebElement crmLogo;
	
	
	//Initializing the page objects
	public LoginPage()

	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCrmImage()
	{
	
		return crmLogo.isDisplayed();
		
	}

	public Homepage Login(String un,String pwd)
	{
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginbutton.submit();
		
		return new Homepage();
	}
}
