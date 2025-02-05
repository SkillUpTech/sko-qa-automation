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

public class ReimbursedValidation implements Callable<String>
{
	ArrayList<ArrayList<String>> sheetData = null;
	WebDriver driver;
	ReimbursedLocator reimbursedLocator;
	String sheetStatus = "Pass";
	
	public ReimbursedValidation(WebDriver driver, ArrayList<ArrayList<String>> sheetData)
	{
		this.sheetData = sheetData;
		this.driver = driver;
	}
	
	
	public void launchCourse(String data)
	{
		String status = reimbursedLocator.checkLaunchCourse(data);
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ReimbursedProcess").get(0).set(0, "launchCourse - failed");
		}
	}
	
	public void checkReimbursedLink()
	{
		String status = reimbursedLocator.checkReimbursedLink();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ReimbursedProcess").get(1).set(0, "checkReimbursedLink - failed");
		}
	}
	
	public void checkLinkFromReimbursedPage()
	{
		String status = reimbursedLocator.checkLinkFromReimbursedPage();
		if(status.equalsIgnoreCase("fail"))
		{
			sheetStatus="Fail";
			RegressionTesting.EXCEL_DATA_AS_SHEEET_NAME_AND_ROWS_MAP.get("ReimbursedProcess").get(2).set(0, "checkLinkFromReimbursedPage - failed");
		}
	}
	@Override
	public String call() throws Exception 
	{
		System.out.println("Microsoft validation Process started");

		try
		{
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		this.reimbursedLocator = new ReimbursedLocator(driver);
		for(int i = 0; i < this.sheetData.size(); i++)
		{
			ArrayList<String> row = this.sheetData.get(i);
			String firstColumn = row.get(0);
			switch(firstColumn)
			{
				case "launchCourse":
					launchCourse(row.get(1));
					break;
				case "checkReimbursedLink":
					checkReimbursedLink();
					break;
				case "checkLinkFromReimbursedPage":
					checkLinkFromReimbursedPage();
					break;
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sheetStatus;
	
	}
}
