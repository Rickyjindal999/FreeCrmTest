package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContextPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	Homepage homepage;
	TestUtil testUtil;
	ContextPage contextPage;
	
	public HomePageTest()
	{
		super();
	}

	// Test cases should be separated -- independent with each other
	// Before each test case -- Launch the browser and login
	// @Test -- execute the case 
	// After each test case -- close the browser 
	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil = new TestUtil();
		loginpage = new LoginPage();
		contextPage = new ContextPage();
		
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest()
	{
		String HomePagetitle= homepage.verifyHomePagetitle();
		Assert.assertEquals(HomePagetitle, "CRMPRO","Home Page tilte not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		
		testUtil.switchToFrame();
		boolean b=homepage.verifyusername();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest()
	{
		testUtil.switchToFrame();
		contextPage =homepage.clickOnContactsLink();
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}	
