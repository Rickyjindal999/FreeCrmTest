package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContextPage extends TestBase{ 

	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLable;

	@FindBy(id="first_name")
	@CacheLookup
	WebElement firstName;
	
	@FindBy(id="surname")
	@CacheLookup
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	@CacheLookup
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	@CacheLookup
	WebElement savebtn;
	
	
	public ContextPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactslable()
	{
		return contactsLable.isDisplayed();
	}
	
	
	// This Test case is failing 
/*	public void selectContacts(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::tb[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow'//input[@name='contact_id']")).click();
	}*/
	
	public void createNewContact(String title,String ftname,String ltname,String comp)
	{
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		company.sendKeys(comp);
		savebtn.click();
	}
	
	
}
