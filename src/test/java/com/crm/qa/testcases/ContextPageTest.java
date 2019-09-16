package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContextPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class ContextPageTest extends TestBase {
	
	LoginPage loginpage;
	Homepage homepage;
	TestUtil testUtil;
	ContextPage contextPage;
	
	String sheetName = "contacts";
	
	public ContextPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		testUtil = new TestUtil();
		contextPage = new ContextPage();
		loginpage = new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contextPage =homepage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void VerifyContactsPageLable()
	{
		boolean b=contextPage.verifyContactslable();
		Assert.assertTrue(b);
	}
	
/*	@Test(priority=2)
	public void selectContactsTest()
	{
		contextPage.selectContacts("Laale Laul");
	}*/
	
	@Test(priority=3, dataProvider="getCrmTestDate")
	public void validatecreateNewContact(String title,String FirstName,String LastName,String Company)
	{
		homepage.newContactLink();
		//contextPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contextPage.createNewContact(title, FirstName, LastName, Company);
		 
	}
	
	
	@DataProvider
	public Object[][] getCrmTestDate()
	{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data ;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
