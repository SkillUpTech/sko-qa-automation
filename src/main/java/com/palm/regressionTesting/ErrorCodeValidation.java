package com.palm.regressionTesting;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Callable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.regression.utility.TestUtil;

public class ErrorCodeValidation implements Callable<String>
{
	WebDriver driver;
	ArrayList<ArrayList<String>> sheetData = null;
	ErrorCodeLocator errorCodeLocator;
	String sheetStatus = "Pass";
	
	public ErrorCodeValidation(ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
	}
	public WebDriver openDriver(String browserName) 
	 {
	        return DriverManager.getDriver(browserName);
	 }
	@Override
	public String call() throws Exception {
		System.out.println("ProgramURL and SLUG verification started");

		try
		{
			driver = this.openDriver(RegressionTesting.nameOfBrowser);
			OpenWebsite.openSite(driver);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		this.errorCodeLocator = new ErrorCodeLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case"url":
					geturl(row);
				break;
				case"urlRedirection":
					urlRedirection(row, i);
				break;
			}
		}
		DriverManager.quitDriver();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	}
	
	
	public void geturl(ArrayList<String> codeFromExcel)
	{
		if(!codeFromExcel.contains("No"))
		{
			ArrayList<String> checkURL = errorCodeLocator.checkCourseCode(codeFromExcel);
			for(int i = 0; i < checkURL.size(); i++)
			{
				if(codeFromExcel.contains(checkURL.get(i)))
				{
					sheetStatus = "Fail";
					int position = codeFromExcel.indexOf(checkURL.get(i));
					String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("URLValidation").get(0).get(position);
					RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("URLValidation").get(0).set(position, (cellValue + " - failed"));
				}
			}
		}
	}
		
	public void urlRedirection(ArrayList<String> codeFromExcel, int rowIndex)
	{
			ArrayList<String> checkURL = errorCodeLocator.checkURLRedirection(codeFromExcel);
			int i = -1;
			if(checkURL.size()>0)
			{
				sheetStatus = "Fail";
				i = 2;
			}
			if( i > -1 )
			{
				String cellValue = RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("URLValidation").get(rowIndex).get(i);
				RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("URLValidation").get(rowIndex).set(i, (cellValue + " - failed"));
			}
	}
}
