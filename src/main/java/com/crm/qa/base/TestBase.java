package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utility.TestUtil;


public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public TestBase()
	{
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\i B M\\eclipse-workspace\\FreeCRMTest\\src\\main\\java"
					+ "\\com\\crm\\qa\\config\\Config.Properties");
			try {
				prop.load(fis);
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			} 
			catch (FileNotFoundException e) {
			e.printStackTrace();
			}
	}
	
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\i B M\\eclipse-workspace\\FreeCRMTest\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		else if (browsername.equals("FF"))
		{
			System.setProperty("webdriver.geckp.driver", "C:\\Users\\i B M\\eclipse-workspace\\FreeCRMTest\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
		
		
		
		

		
		
	}
}
