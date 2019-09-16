package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase{ 

	@FindBy(xpath="//td[contains(text(),'User: Sahil Gupta')]")
	@CacheLookup
	WebElement usenameLable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	@CacheLookup
	WebElement newContactslink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	@CacheLookup
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	@CacheLookup
	WebElement Taskslink;
	
	
	//Initializing the page objects
		public Homepage()
		{
			PageFactory.initElements(driver, this);
		}

		
		public String verifyHomePagetitle()
		{
			return driver.getTitle();
		}
		
		public boolean verifyusername()
		{
			return usenameLable.isDisplayed();
		}
		
		
		
		public ContextPage clickOnContactsLink()
		{
			
			contactslink.click();
			return new ContextPage();
		}
		
		public Dealspage clickOnDealsLink()
		{
			dealslink.click();
			return new Dealspage();
		}
		
		public TasksPage clickOnTaskslink()
		{
			Taskslink.click();
			return new TasksPage();
		}
		
		public void newContactLink()
		{
			Actions action = new Actions(driver);
			action.moveToElement(contactslink).build().perform();
			newContactslink.click();
		}
		
}
