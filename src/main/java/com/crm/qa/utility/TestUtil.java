package com.crm.qa.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long  Page_Load = 20;
	public static long  Implicit_wait = 30;
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\i B M\\eclipse-workspace\\FreeCRMTest\\src"
			+ "\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx";
	
	
	public static Workbook book;
	public static Sheet sheet;
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i=0;i< sheet.getLastRowNum(); i++)
		{
			for(int k=0;k< sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;   
	}


	
}
